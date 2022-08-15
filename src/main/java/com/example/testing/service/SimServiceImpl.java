package com.example.testing.service;

import com.example.testing.dbAdapter.dao.SimDao;
import com.example.testing.dbAdapter.repository.SimRepository;
import com.example.testing.mapper.SimMapper;
import com.example.testing.model.SimRequest;
import com.example.testing.model.SimResponse;
import com.example.testing.model.Sims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SimServiceImpl implements ISimService{

    @Autowired
    SimRepository simRepository;

    @Autowired
    SimMapper simMapper;

    private Logger logger = Logger.getLogger("logger");
    @Override
    public SimResponse createSim(SimRequest simRequest) {
        SimDao simDao = simMapper.toSimDao(simRequest);
        logger.info("date: "+simDao.getExpiryDate());
        return simMapper.toSim(simRepository.save(simDao));
    }

    @Override
    public Sims fetchAll() {
        Sims sims = new Sims();
        List<SimResponse> simRequestDetails = simMapper.toSimList(simRepository.findAll());
        sims.setSimRequestList(simRequestDetails);
        return sims;
    }

    @Override
    public SimResponse updateRecord(Long id, SimRequest simRequest) throws Exception{
        Optional<SimDao> sim = simRepository.findById(id);
        SimResponse simResponse = new SimResponse();
        if(sim.isPresent()){
            SimDao  updatedSim  = simMapper.toSimDao(simRequest);
            updatedSim.setId(id);
            simResponse = simMapper.toSim(simRepository.save(updatedSim));
        }else{
            throw new Exception("Not found");
        }
        return simResponse;
    }

    @Override
    public void deleteRecord(Long id) throws  Exception{
        Optional<SimDao> sim = simRepository.findById(id);
        if(sim.isPresent()){
            simRepository.delete(sim.get());
        }else{
            throw new Exception("Not found");
        }
    }

    @Override
    public Sims findAllRecordsToBeRenewed() {
        LocalDate date = LocalDate.now();
        Sims sims = new Sims();
        Date startDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, 30);
        Date endDate = c.getTime();
        sims.setSimRequestList(simMapper.toSimList(simRepository.findAllByExpiryDateBetween(startDate, endDate)));
        return sims;
    }

    @Override
    public void renewPack(Long id) throws Exception{
        Optional<SimDao> sim = simRepository.findById(id);
        if(sim.isPresent()){
            SimDao record = sim.get();
            Date dt = record.getExpiryDate();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 30);
            dt = c.getTime();
            record.setExpiryDate(dt);
        }else{
            throw new Exception("Not found");
        }
    }
}
