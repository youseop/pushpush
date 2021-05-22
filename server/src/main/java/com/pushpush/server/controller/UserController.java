package com.pushpush.server.controller;

import com.google.gson.JsonObject;
import com.pushpush.server.vo.users.Users;
import com.pushpush.server.vo.users.UsersRepository;
import com.pushpush.server.service.JwtUserDetailsService;
import com.pushpush.server.web.users.CharacterDto;
import com.pushpush.server.web.users.Response;
import com.pushpush.server.web.users.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JwtUserDetailsService userService;
    private UsersRepository userRepository;

    @PostMapping("/api/users/register")
    public Response signup(@RequestBody UserDto infoDto) { // 회원 추가
        Response response = new Response();

        try {
            if(userService.checkId(infoDto.getId())){
                userService.save(infoDto);
                response.setSuccess(true);
                response.setResponse("success");
                response.setMessage("회원가입을 성공적으로 완료했습니다.");
            }
            else{
                response.setSuccess(false);
                response.setResponse("failed");
                response.setMessage("존재하는 id 입니다.");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setResponse("failed");
            response.setMessage("회원가입을 하는 도중 오류가 발생했습니다.");
            response.setData(e.toString());
        }
        return response;
    }

    @GetMapping("/api/users/auth")
    public ResponseEntity<?> authUser(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        String value;
        Users user;

        if(cookies != null){
            for(Cookie cookie : cookies) {
                if("userId".equals(cookie.getName())) {
                    value = cookie.getValue();
                    user = userService.getUser(value);
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/users/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        String token;

        if(cookies != null){
            for(Cookie cookie : cookies) {
                if("userId".equals(cookie.getName())) {
                    String id = cookie.getValue();
                    userService.saveToken(id, null);
                    break;
                }
            }
        }

        Cookie myCookie = new Cookie("userToken", null);
        myCookie.setMaxAge(0);
        myCookie.setPath("/");
        response.addCookie(myCookie);

        Cookie idCookie = new Cookie("userId", null);
        idCookie.setMaxAge(0);
        idCookie.setPath("/");
        response.addCookie(idCookie);

        JsonObject obj =new JsonObject();
        obj.addProperty("success", true);

        return obj.toString();
    }

    @PostMapping("/api/users/character")
    public String customize(@RequestBody CharacterDto character, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Integer option = character.getOption();
        String value;
        Users user;
        JsonObject obj =new JsonObject();

        try{
            if(cookies != null){
                for(Cookie cookie : cookies) {
                    if("userId".equals(cookie.getName())) {
                        value = cookie.getValue();
                        userService.saveCharacter(value, option);

                        obj.addProperty("success", true);
                        return obj.toString();
                    }
                }
            }
        }catch(Exception e){
            obj.addProperty("success", false);
            return obj.toString();
        }

        obj.addProperty("success", false);
        return obj.toString();
    }
}
