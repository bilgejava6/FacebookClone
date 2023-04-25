package com.muhammet.service;

import com.muhammet.repository.IPostRepository;
import com.muhammet.repository.entity.Post;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostService  extends ServiceManager<Post,String> {
    private final IPostRepository repository;
    public PostService(IPostRepository repository){
        super(repository);
        this.repository=repository;
    }
}
