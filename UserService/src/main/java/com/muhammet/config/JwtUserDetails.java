package com.muhammet.config;

import com.muhammet.exception.ErrorType;
import com.muhammet.exception.UserException;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {
    private final IUserProfileRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByAuthId(Long authId){
        /**
         * Öncelikle authid üzerinden kullanıcı profilinin olup olmadığını doğruluyoruz.
         */
        Optional<UserProfile> userProfile =  repository.findOptionalByAuthid(authId);
        /**
         * Kullanıcıya ait yetki bilgilerini bir tabloda tutmak gereklidir. Bu tablo genellikle ROL tablosudur.
         * kullanıcının rollerinin tutulduğu yetkilerini olduğu bir tablodur. bu tablodan bilgiler çekilerek
         * kullanıcıya ait yetkileri UserDetails nesnesine eklemek gereklidir.
         */
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("CANIM_ISTEDI_BIR_ROL_YAZDIM"));
        authorities.add(new SimpleGrantedAuthority("NE_OLA_KI"));
        authorities.add(new SimpleGrantedAuthority("BIR_TANE_DE_SENI_ICIN_YAZAYIM"));

        /**
         * kullanıcı yok ise, geçersiz token fıratıyoruz.
         */
        if(userProfile.isEmpty())
            throw new UserException(ErrorType.ERROR_INVALID_TOKEN);
        UserDetails user = User.builder()
                .accountExpired(false) // hesap süresi dolmuş mu? bunu userProfile bilgisinin içinde tutuyor olmamız gerekir. ya da
                                        // ayrı bir tabloda tutuyor olmamız gerekir.
                .accountLocked(false) // hesap kilitli mi? burada kişi hesabını bir şekilde kilitlemiş ya da
                                     // bizim tarafımızdan kilitlenmiş olabilir.
                .username(userProfile.get().getUsername())
                .password("")
                .authorities(authorities)
                .build();
        return user;
    }
}
