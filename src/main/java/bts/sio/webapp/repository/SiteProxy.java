package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Site;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component

public class SiteProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all site
     * @return An iterable of all site
     */
    public Iterable<Site> getLesSites() {

        String baseApiUrl = props.getApiUrl();
        String getSiteUrl = baseApiUrl + "/sites";
        System.out.println("url=" + getSiteUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Site>> response = restTemplate.exchange(
                getSiteUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Site>>() {}
        );

        log.debug("Get Site call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
