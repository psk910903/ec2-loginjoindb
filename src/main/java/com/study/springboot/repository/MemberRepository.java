package com.study.springboot.repository;

import com.study.springboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from member m where m.user_id = :user_id and m.user_pw = :user_pw", nativeQuery = true)
    List<Member> findByUserIdAndUserPw(@Param("user_id") String user_id,
                                       @Param("user_pw") String user_pw);

    @Query(value = "select * from member m where m.user_id = :user_id", nativeQuery = true)
    List<Member> findByUserId(@Param("user_id") String user_id);
}
