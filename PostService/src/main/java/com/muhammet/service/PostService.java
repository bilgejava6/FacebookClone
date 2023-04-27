package com.muhammet.service;

import com.muhammet.dto.request.GetPostRequestDto;
import com.muhammet.dto.response.GetPostResponseDto;
import com.muhammet.repository.IPostRepository;
import com.muhammet.repository.entity.Post;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService  extends ServiceManager<Post,String> {
    private final IPostRepository repository;
    public PostService(IPostRepository repository){
        super(repository);
        this.repository=repository;
    }

    public List<GetPostResponseDto> getPosts(GetPostRequestDto dto) {
        List<Post> postList = repository.findAll();

        return null;
    }
}
