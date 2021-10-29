package com.zuk.service.impl;





import com.zuk.dto.AuthDto;
import com.zuk.dto.UBsendAuthDto;
import com.zuk.model.User;
import com.zuk.repository.UserRepository;
import com.zuk.service.AuthService;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UBsendAuthDto login(AuthDto authDto) throws JSONException {
        userRepository.deleteAll();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("username", "assignment-test@ubsend.com");
        personJsonObject.put("password", "p0DrmE)E+BQH$]KasMSb");
        personJsonObject.put("сlientID", "15342");

        logger.debug(personJsonObject.toString());

        HttpEntity<String> entity = new HttpEntity<String>(personJsonObject.toString(), headers);
        ResponseEntity<UBsendAuthDto> response = restTemplate.postForEntity( "https://staging-api.ubsend.io/v1/auth/login", entity ,  UBsendAuthDto.class );

        logger.debug(response.toString());

        long laterDate = System.currentTimeMillis();

//        int expireInMi = Math.toIntExact(response.getBody().getExpiresIn());
//
//        Timestamp original = new Timestamp(laterDate);
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(original.getTime());
//        cal.add(Calendar.MILLISECOND, expireInMi);
//        Timestamp expireIn = new Timestamp(cal.getTime().getTime());

        UBsendAuthDto uBsendAuthDto = response.getBody();

        User user = new User(uBsendAuthDto.getFirstName(),uBsendAuthDto.getLastName(),uBsendAuthDto.getUsername(),uBsendAuthDto.getAccessToken(), new Date());

        UBsendAuthDto ubd = new UBsendAuthDto();

        return ubd.fromUser(userRepository.save(user));
    }
}
