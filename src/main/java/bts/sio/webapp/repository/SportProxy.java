package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Sport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component

public class SportProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all pays
     * @return An iterable of all sport
     */
    public Iterable<Sport> getLesSports() {

        String baseApiUrl = props.getApiUrl();
        String getSportUrl = baseApiUrl + "/sport";
        System.out.println("url=" + getSportUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Sport>> response = restTemplate.exchange(
                getSportUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Sport>>() {}
        );

        log.debug("Get Sport call " + response.getStatusCode().toString());

        return response.getBody();
    }

}
