package com.muhammet.controller;

import com.muhammet.dto.request.GetPostRequestDto;
import com.muhammet.dto.response.GetPostResponseDto;
import com.muhammet.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/getposts")
    public ResponseEntity<List<GetPostResponseDto>> getPosts(@RequestBody @Valid GetPostRequestDto dto){
        return ResponseEntity.ok(postService.getPosts(dto));
    }
}
