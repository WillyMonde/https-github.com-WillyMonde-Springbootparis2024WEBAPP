package bts.sio.webapp.service;

import bts.sio.webapp.model.Site;
import bts.sio.webapp.repository.SiteProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service

public class SiteService {

    @Autowired
    private SiteProxy siteProxy;
    public Iterable<Site> getLesSites() {return siteProxy.getLesSites();
    }
}
