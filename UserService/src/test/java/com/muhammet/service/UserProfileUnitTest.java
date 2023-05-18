package com.muhammet.service;

import com.muhammet.dto.request.GetMyProfileRequestDto;
import com.muhammet.dto.response.GetMyProfileResponseDto;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.utility.JwtTokenManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserProfileUnitTest {

    @InjectMocks
    UserProfileService userProfileService;
    @Mock
    IUserProfileRepository userProfileRepository;
    @Mock
    JwtTokenManager jwtTokenManager;

    @Test
    void getMyProfileTest(){

        GetMyProfileResponseDto responseDto = userProfileService.getMyProfile(GetMyProfileRequestDto.builder()
                        .token("5634gdf456456456")
                .build());
        Assertions.assertTrue(responseDto != null);
    }

}
