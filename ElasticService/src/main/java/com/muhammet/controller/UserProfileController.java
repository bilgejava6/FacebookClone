package com.muhammet.controller;

import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;
}
