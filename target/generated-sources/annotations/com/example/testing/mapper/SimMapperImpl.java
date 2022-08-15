package com.example.testing.mapper;

import com.example.testing.dbAdapter.dao.SimDao;
import com.example.testing.model.SimRequest;
import com.example.testing.model.SimResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-15T14:44:12+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class SimMapperImpl implements SimMapper {

    @Override
    public SimResponse toSim(SimDao simDao) {
        if ( simDao == null ) {
            return null;
        }

        SimResponse simResponse = new SimResponse();

        simResponse.setId( simDao.getId() );
        simResponse.setSimCardNo( simDao.getSimCardNo() );
        simResponse.setMobileNo( simDao.getMobileNo() );
        simResponse.setStatus( simDao.getStatus() );
        simResponse.setStateOfRegistration( simDao.getStateOfRegistration() );
        simResponse.setKyc( simDao.getKyc() );
        simResponse.setTelecomProvider( simDao.getTelecomProvider() );
        simResponse.setFullName( simDao.getFullName() );

        simResponse.setExpiryDate( convertToString(simDao.getExpiryDate()) );

        return simResponse;
    }

    @Override
    public SimDao toSimDao(SimRequest simRequest) {
        if ( simRequest == null ) {
            return null;
        }

        SimDao simDao = new SimDao();

        simDao.setSimCardNo( simRequest.getSimCardNo() );
        simDao.setMobileNo( simRequest.getMobileNo() );
        simDao.setStatus( simRequest.getStatus() );
        simDao.setStateOfRegistration( simRequest.getStateOfRegistration() );
        simDao.setKyc( simRequest.getKyc() );
        simDao.setTelecomProvider( simRequest.getTelecomProvider() );
        simDao.setFullName( simRequest.getFullName() );

        simDao.setExpiryDate( convertToDate(simRequest.getExpiryDate()) );

        return simDao;
    }

    @Override
    public List<SimResponse> toSimList(List<SimDao> simDaoList) {
        if ( simDaoList == null ) {
            return null;
        }

        List<SimResponse> list = new ArrayList<SimResponse>( simDaoList.size() );
        for ( SimDao simDao : simDaoList ) {
            list.add( toSim( simDao ) );
        }

        return list;
    }
}
