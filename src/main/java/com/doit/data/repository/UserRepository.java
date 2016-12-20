package com.doit.data.repository;

import com.doit.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user WHERE email= :email", nativeQuery = true)
    boolean isEmailExist(@Param("email") String email);

    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user WHERE email= :email AND id != :excludedUserID", nativeQuery = true)
    boolean isEmailExist(@Param(value = "email") String email, @Param(value = "excludedUserID") long excludedUserID);
}
