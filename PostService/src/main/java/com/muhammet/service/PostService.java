package com.muhammet.service;

import com.muhammet.dto.request.GetPostRequestDto;
import com.muhammet.dto.response.GetPostResponseDto;
import com.muhammet.repository.IPostRepository;
import com.muhammet.repository.entity.Post;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService  extends ServiceManager<Post,String> {
    private final IPostRepository repository;
    private final PostResimService postResimService;
    public PostService(IPostRepository repository, PostResimService postResimService) {
        super(repository);
        this.repository=repository;
        this.postResimService=postResimService;
    }

    public List<GetPostResponseDto> getPosts(GetPostRequestDto dto) {
        /**
         * öncelikle kullanıcıya dönülecek olan listenin boş halini oluşturuyoruz.
         */
        List<GetPostResponseDto> result = new ArrayList<>();
        /**
         * Tüm Postların listesini çekiyoruz.
         */
        List<Post> postList = repository.findAll();
        postList.forEach(post->{
            List<String> posturls = postResimService.getUrlsByPostId(post.getId());
            /**
             * Kullanıcıya dönülecek response dto oluşturuluyor.
             */
            GetPostResponseDto getPDto = GetPostResponseDto.builder()
                    .likecount(post.getBegenisayisi())
                    .username("Muhammet")
                    .useravatar("https://randomuser.me/api/portraits/men/31.jpg")
                    .sharedtime(new Date(post.getPaylasimzamani())+"")
                    .posttext(post.getAciklama())
                    .posturls(posturls)
                    .build();
            result.add(getPDto);
        });
        return result;
    }
}
