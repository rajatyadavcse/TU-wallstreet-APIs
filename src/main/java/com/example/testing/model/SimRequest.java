package com.example.testing.model;

import lombok.Data;

@Data
public class SimRequest {
    private Long simCardNo;

    private Long mobileNo;

    private String status;

    private String expiryDate;

    private String stateOfRegistration;

    private String kyc;

    private String telecomProvider;

    private String fullName;
}
