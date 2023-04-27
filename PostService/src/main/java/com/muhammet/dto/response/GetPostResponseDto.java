package com.muhammet.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetPostResponseDto {
    String useravatar;
    String username;
    String posturl;
    int likecount;
    String sharedtime;
    String posttext;
}
