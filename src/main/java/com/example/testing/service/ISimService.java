package com.example.testing.service;

import com.example.testing.model.SimRequest;
import com.example.testing.model.SimResponse;
import com.example.testing.model.Sims;

public interface ISimService {
    SimResponse createSim(SimRequest simRequest);

    Sims fetchAll();

    SimResponse updateRecord(Long id, SimRequest simRequest) throws Exception;

    void deleteRecord(Long id) throws Exception;

    Sims findAllRecordsToBeRenewed();

    void renewPack(Long id) throws  Exception;
}
