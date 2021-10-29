package com.zuk.service.impl;

import com.zuk.dto.ParcelShopList;
import com.zuk.model.ParcelShop;
import com.zuk.model.User;
import com.zuk.repository.ParcelShopRepository;
import com.zuk.repository.UserRepository;
import com.zuk.service.ParcelShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ParcelShopServiceImpl implements ParcelShopService {

    private final ParcelShopRepository shopRepository;
    private final UserRepository userRepository;

    @Autowired
    public ParcelShopServiceImpl(ParcelShopRepository shopRepository, UserRepository userRepository) {
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ParcelShop> getFirstPageParcel() {
        User user = userRepository.findByFirstName("Developer");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + user.getAccessToken());
        headers.set("ClientId", "15342");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        //ParcelShopList parcelShopList = restTemplate.getForObject("https://staging-api.ubsend.io/v1/parcel-shops/parcel-shops?radius=10000&carrier=CORREOS&country=ES&limit=10", entity, ParcelShopList.class);

        ResponseEntity<List<ParcelShop>> rateResponse =
                restTemplate.exchange("https://staging-api.ubsend.io/v1/parcel-shops/parcel-shops?radius=10000&carrier=CORREOS&country=ES&limit=10",
                        HttpMethod.GET, entity, new ParameterizedTypeReference<List<ParcelShop>>() {
                        });
        List<ParcelShop> parcelShops = rateResponse.getBody();

        return shopRepository.saveAll(parcelShops);
    }
}
