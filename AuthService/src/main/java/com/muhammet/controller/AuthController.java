package com.muhammet.controller;

import com.muhammet.dto.request.LoginRequestDto;
import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.dto.response.LoginResponseDto;
import com.muhammet.dto.response.RegisterResponseDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.ErrorType;
import com.muhammet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto){
        if(!authService.doLogin(dto))
            return ResponseEntity.ok(LoginResponseDto.builder()
                            .statusCode(4000)
                            .message("Kullanıcı adı veya şifre hatalı")
                    .build());

        return ResponseEntity.ok(LoginResponseDto.builder()
                        .statusCode(2001)
                        .message("Giriş işlemi başarılı")
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        if(!dto.getPassword().equals(dto.getRepassowrd()))
            throw new AuthException(ErrorType.ERROR_PASSWORD);
        authService.register(dto);
        return ResponseEntity.ok(RegisterResponseDto.builder()
                        .statusCode(2000)
                        .message("Kayıt işlemi baraşılır şekilde gerçekleşti. Lütfen E-Pasta" +
                                " adresinize gelen aktivasyon linkine tıklayınız.")
                .build());
    }
}
