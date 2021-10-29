package com.zuk.repository;

import com.zuk.model.ParcelShop;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParcelShopRepository  extends MongoRepository<ParcelShop, String> {
    //TODO pagination, find by different params
}
