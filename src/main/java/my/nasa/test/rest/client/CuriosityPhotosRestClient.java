package my.nasa.test.rest.client;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class CuriosityPhotosRestClient {
    private static final Logger logger = LogManager.getLogger(CuriosityPhotosRestClient.class.getName());
    private static final String baseURI = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";

    public ResponseEntity<String> get(Map<String, String> params) {
        StringBuilder parsedURI = new StringBuilder(baseURI);
        parsedURI.append("?");
        for (String parName : params.keySet()) {
            parsedURI.append(String.format("%1$s={%1$s}&", parName));
        }
        parsedURI.deleteCharAt(parsedURI.length() - 1);

        logger.info("Getting response from URI " + parsedURI.toString());
        return new RestTemplate().getForEntity(parsedURI.toString(), String.class, params);
    }
}
