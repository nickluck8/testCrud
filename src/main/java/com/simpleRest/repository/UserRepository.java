package com.simpleRest.repository;

import com.simpleRest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u WHERE u.username = :uName")
    User findByUsername(@Param("uName") String username);

    @Query("select u from User u where u.id=:uId")
    User findUserById(@Param("uId")Long uId);
}
