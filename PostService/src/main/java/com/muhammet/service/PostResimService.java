package com.muhammet.service;

import com.muhammet.repository.IPostRepository;
import com.muhammet.repository.IPostResimRepository;
import com.muhammet.repository.entity.PostResim;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostResimService  extends ServiceManager<PostResim,String> {
    private final IPostResimRepository repository;

    public PostResimService(IPostResimRepository repository){
        super(repository);
        this.repository=repository;
    }
}
