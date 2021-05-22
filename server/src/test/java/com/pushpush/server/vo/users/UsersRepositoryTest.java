package com.pushpush.server.vo.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
public class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @AfterEach
    public void cleanup(){
        usersRepository.deleteAll();
    }

    @Test
    public void saveUser(){
        String id = "abc";
        String pw = "123";
        Long major = 1L;

        usersRepository.save(Users.builder().id(id).password(pw).major_idx(major).build());

        List<Users> usersList = usersRepository.findAll();

        Users users = usersList.get(0);
        then(id).isEqualTo(users.getId());
        then(pw).isEqualTo((users.getPassword()));

    }
}
