package com.pushpush.server.vo.major;

import com.pushpush.server.vo.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {

}
