package com.muhammet.service;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {
    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository){
        super(repository);
        this.repository=repository;
    }

    public void save(UserProfileSaveRequestDto dto){
       save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
    }

}
