package com.example.testing.dbAdapter.repository;

import com.example.testing.dbAdapter.dao.SimDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SimRepository extends JpaRepository<SimDao, Long> {

    List<SimDao> findAllByExpiryDateBetween(Date startDate, Date endDate);
}
