package com.example.testing.dbAdapter.dao;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Sim")
@Data
public class SimDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Sim_card_no")
    private Long simCardNo;

    @Column(name = "Mobile_no")
    private Long mobileNo;

    @Column(name = "Status")
    private String status;

    @Column(name = "Expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    @Column(name = "State_of_registration")
    private String stateOfRegistration;

    @Column(name = "KYC")
    private String kyc;

    @Column(name = "Telecom_Provider")
    private String telecomProvider;

    @Column(name = "Full_name")
    private String fullName;
}
