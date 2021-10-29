package com.zuk.rest;


import com.zuk.service.ParcelShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/parcel-shop")
public class ParcelRestControllerV1 {

    private final ParcelShopService parcelShopService;

    @Autowired
    public ParcelRestControllerV1(ParcelShopService parcelShopService) {
        this.parcelShopService = parcelShopService;
    }

    @GetMapping("/")
    public ResponseEntity getParcelsShop()  {
        //TODO check token expire
        return ResponseEntity.ok(parcelShopService.getFirstPageParcel());
    }

}
