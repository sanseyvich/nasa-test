package my.nasa.test.api;

import my.nasa.test.rest.client.CuriosityPhotosRestClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import my.nasa.test.dto.Photo;
import my.nasa.test.utils.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

public class CuriosityPhotosComparisonTest {
    private static CuriosityPhotosRestClient client;
    private static List<Photo> responseBySol;
    private static List<Photo> responseByDate;

    private static final int imagesToCompareCount = 10;
    private static final int cameraPhotosMaxMultiplier = 10;

    @BeforeClass
    public static void extractData() {
        client = new CuriosityPhotosRestClient();

        //specify query params for client to obtain data
        Map<String, String> paramsSol = new HashMap<>(2);
        Map<String, String> paramsDate = new HashMap<>(2);
        paramsSol.put("sol", "1000");
        paramsSol.put("api_key", "DEMO_KEY");
        paramsDate.put("earth_date", "2015-5-30");
        paramsDate.put("api_key", "DEMO_KEY");

        responseBySol = Utils.extractPhotosFromJson(client
                .get(paramsSol)
                .getBody());

        responseByDate = Utils.extractPhotosFromJson(client
                .get(paramsDate)
                .getBody());
    }

    /**
     * Compares META data of first <code>imagesToCompareCount</code> photos for
     * <code>responseBySol</code> and <code>responseByDate</code>
     */
    @Test
    public void isPhotoJsonEntitiesBySolAndEarthDateAreEqual() {
        for (int i = 0; i < imagesToCompareCount; i++) {
            Photo bySol = responseBySol.get(i);
            Photo byDate = responseByDate.get(i);
            Assert.assertEquals("Failed matching photos with id = " + bySol.getId(),
                    bySol,
                    byDate);
        }
    }

    /**
     * Compares images itself of the first <code>imagesToCompareCount</code> photos for
     * <code>responseBySol</code> and <code>responseByDate</code>
     */
    @Test
    public void isPhotoImagesBySolAndEarthDateAreEqual() {
        IntStream.range(0, imagesToCompareCount)
                .parallel()
                .forEach(index -> {
                    try {
                        Assert.assertTrue(
                                Utils.compareImages(
                                        new URL(responseBySol.get(index).getImg_src()),
                                        new URL(responseByDate.get(index).getImg_src())));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Comparing photos amount made by each camera within <code>responseBySol</code>.
     * If any made more than <code>cameraPhotosMaxMultiplier</code> times images than any other - test would fail.
     */
    @Test
    public void camerasPhotosAmountComparisonTest() {
        HashMap<String, Integer> photosCount = new HashMap<>(responseBySol.size());
        for (Photo photo : responseBySol) {
            String camName = photo.getCamera().getName();
            if (photosCount.get(camName) != null) {
                photosCount.put(camName, photosCount.get(camName) + 1);
            } else
                photosCount.put(camName, 1);
        }

        //extract ordered values from map - natural ordering of Integers
        TreeSet<Integer> orderedVals = new TreeSet<>(photosCount.values());
        double phCountRel = orderedVals.last() / orderedVals.first();
        Assert.assertFalse(
                String.format("Most productive camera made %f times more photos than least productive - expected less than %d",
                        phCountRel, cameraPhotosMaxMultiplier),
                phCountRel > 10);

    }
}
