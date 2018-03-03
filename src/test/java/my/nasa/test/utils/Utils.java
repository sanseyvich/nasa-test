package my.nasa.test.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import my.nasa.test.dto.Photo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.net.URL;
import java.util.List;

/**
 * <p>
 * Contains utility methods for the Validation of NASA API implementation.
 * Includes images comparison and json parsing methods required for verification purposes.
 * </p>
 */
public final class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class.getName());

    /**
     * Compares images via matching of each data array's element of {@link java.awt.image.DataBuffer}
     * extracted from {@link java.awt.image.BufferedImage}
     *
     * @param imageA <code>URL</code> of the first image to compare.
     * @param imageB <code>URL</code> of the second image to compare.
     * @return
     */
    public static boolean compareImages(URL imageA, URL imageB) {
        logger.debug(String.format("Comparing images by URLs - %s and %s",
                imageA.toString(),
                imageB.toString()));
        try {
            // take buffer data from both image files //
            BufferedImage biA = ImageIO.read(imageA);

            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();

            BufferedImage biB = ImageIO.read(imageB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();

            // compare data-buffer objects //

            if (sizeA == sizeB) {
                for (int i = 0; i < sizeA; i++) {
                    if (dbA.getElem(i) != dbB.getElem(i)) {
                        return false;
                    }
                }
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            logger.info(String.format("Failed to compare images by URLs - %s and %s",
                    imageA.toString(),
                    imageB.toString()), e);
            return false;
        }
    }

    /**
     * Extracts "photos" entities from json structure to list of POJO's
     *
     * @param json String representation of json structure
     * @return List of mapped {@link Photo} entities
     */
    public static List<Photo> extractPhotosFromJson(String json) {
        JsonParser parser = new JsonParser();
        JsonElement photosNode = parser
                .parse(json)
                .getAsJsonObject()
                .get("photos");
        List<Photo> photos = new Gson()
                .fromJson(
                        photosNode,
                        new TypeToken<List<Photo>>() {
                        }.getType());
        return photos;
    }
}
