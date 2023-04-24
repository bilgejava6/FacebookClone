package com.muhammet.service;

import com.muhammet.dto.request.UserProfileDto;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {
    private final IUserProfileRepository repository;
    public UserProfileService( IUserProfileRepository repository){
        super(repository);
        this.repository=repository;
    }

    public void save(UserProfileDto dto){
        UserProfile user = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        save(user);
    }
}
