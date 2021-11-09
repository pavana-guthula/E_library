package com.assignment.elibrary.repository;

import com.assignment.elibrary.pojo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUserName(String username);
    public User findById(int id);
}
