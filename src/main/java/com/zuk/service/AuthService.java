package com.zuk.service;

import com.zuk.dto.AuthDto;
import com.zuk.dto.UBsendAuthDto;
import org.json.JSONException;

public interface AuthService {
    UBsendAuthDto login(AuthDto authDto) throws JSONException;
}
