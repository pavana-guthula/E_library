package com.assignment.elibrary.repository;

import com.assignment.elibrary.pojo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryByName extends CrudRepository<User, String> {
    public User findByUserName(String userName);
}
