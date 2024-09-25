package bts.sio.webapp.service;

import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.repository.OlypiadeProxy;
import org.springframework.beans.factory.annotation.Autowired;

public class OlympiadeService {


    @Autowired
    private OlypiadeProxy olympiadeProxy;
    public Iterable<Olympiade> getLesOlympiade() {
        return olympiadeProxy.getLesOlympiades();
    }
}