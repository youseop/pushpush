package com.pushpush.server.web.jwt;

import com.pushpush.server.vo.major.MajorRepository;
import com.pushpush.server.vo.users.Users;
import com.pushpush.server.vo.users.UsersRepository;
import com.pushpush.server.web.users.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;
    private final MajorRepository majorRepository;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param id 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public Users loadUserByUsername(String id) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException((id)));
    }
    /**
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    @Transactional
    public Long save(UserDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(Users.builder()
                .id(infoDto.getId())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword())
                .major_idx(infoDto.getMajor_idx()).build()).getUser_idx();
    }

    @Transactional
    public void saveToken(String id, String token) {
        userRepository.updateToken(id, token);

    }

    @Transactional
    public Users getUser(String id){
        Users user = userRepository.findById(id).get();

        return user;
    }

}