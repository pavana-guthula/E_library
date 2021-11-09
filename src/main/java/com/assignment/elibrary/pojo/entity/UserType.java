package com.assignment.elibrary.pojo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "User_Types")
public class UserType {

    @Id
    @Column( name = "Type_ID", updatable = false, nullable = false)
    @GeneratedValue
    int typeId;

    @Column( name = "Type", nullable = false)
    String userType;

}
