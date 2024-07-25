package com.handyman.mvp.repositiry;

import com.handyman.mvp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from User u where u.id = ?1")
    User getUserById(long id);

}
