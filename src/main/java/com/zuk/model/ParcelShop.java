package com.zuk.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ParcelShop {
    //TODO ADD DTO LAYOUT
    @Id
    private String Id;
    private String name;
    private String type;
    private String latitude;
    private String longitude;
    private String carrier;
    private String addressLine1;
    private String postCode;
    private String city;
    private String country;
//    private String openingTimes;
//    private String carrierData;

}
