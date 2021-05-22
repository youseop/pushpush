package com.pushpush.server.vo.major;

import com.pushpush.server.vo.users.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
    List<Major> findByOrderByPointDesc();

    @Transactional
    @Modifying
    @Query("UPDATE major SET point = :point WHERE major_idx = :major_idx")
    void updatePoint(@Param("point") Integer point, @Param("major_idx") Long major_idx);
}
