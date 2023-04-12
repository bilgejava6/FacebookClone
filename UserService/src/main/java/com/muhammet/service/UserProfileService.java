package com.muhammet.service;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.dto.request.UserProfileUpdateRequestDto;
import com.muhammet.exception.ErrorType;
import com.muhammet.exception.UserException;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.JwtTokenManager;
import com.muhammet.utility.ServiceManager;
import com.muhammet.utility.TokenCreator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {
    private final IUserProfileRepository repository;
    private final JwtTokenManager jwtTokenManager;
    public UserProfileService(IUserProfileRepository repository,
                              JwtTokenManager jwtTokenManager) {
        super(repository);
        this.repository=repository;
        this.jwtTokenManager=jwtTokenManager;
    }

    public void save(UserProfileSaveRequestDto dto){
       save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
    }

    public void update(UserProfileUpdateRequestDto dto){
        Optional<Long> authid = jwtTokenManager.getIdFromToken(dto.getToken());
        if(authid.isEmpty())
            throw new UserException(ErrorType.ERROR_INVALID_TOKEN);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthid(authid.get());
        if(userProfile.isPresent()){
            UserProfile profile = userProfile.get();
            profile.setAddress(dto.getAddress());
            profile.setAvatar(dto.getAvatar());
            profile.setGender(dto.getGender());
            profile.setName(dto.getName());
            profile.setPhone(dto.getPhone());
            profile.setSurname(dto.getSurname());
            update(profile);
        }
    }
}
