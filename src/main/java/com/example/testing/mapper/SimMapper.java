package com.example.testing.mapper;

import com.example.testing.dbAdapter.dao.SimDao;
import com.example.testing.model.SimRequest;
import com.example.testing.model.SimResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface SimMapper {
    @Mapping(target = "expiryDate", expression = "java(convertToString(simDao.getExpiryDate()))")
    SimResponse toSim(SimDao simDao);

    @Mapping(target = "expiryDate", expression = "java(convertToDate(simRequest.getExpiryDate()))")
    SimDao toSimDao(SimRequest simRequest);

    List<SimResponse> toSimList(List<SimDao> simDaoList);

    default Date convertToDate(String date){
        if(null != date){
            try {
                return new SimpleDateFormat("dd-MM-yyyy").parse(date);
            } catch (ParseException e){
                throw new RuntimeException( e );
            }
        }
        return null;
    }
    default String convertToString(Date date){
        if(null != date){
            try {
                return new SimpleDateFormat("dd-MM-yyyy").format(date);
            } catch (Exception e){
                throw new RuntimeException( e );
            }
        }
        return null;
    }
}
