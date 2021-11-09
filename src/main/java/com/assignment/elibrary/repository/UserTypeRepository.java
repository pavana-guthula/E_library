package com.assignment.elibrary.repository;

import com.assignment.elibrary.pojo.entity.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
    public UserType findById(int typeId);
}
