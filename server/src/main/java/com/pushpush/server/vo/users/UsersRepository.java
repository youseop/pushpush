package com.pushpush.server.vo.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(String id);

    @Transactional
    @Modifying
    @Query("UPDATE user SET token = :token WHERE id = :id")
    void updateToken(@Param("id") String id, @Param("token") String token);

    @Transactional
    @Modifying
    @Query("UPDATE user SET character_option = :option WHERE id = :id")
    void updateCharacter(@Param("id") String id, @Param("option") Integer option);

}
