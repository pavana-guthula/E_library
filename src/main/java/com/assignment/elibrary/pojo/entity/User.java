package com.assignment.elibrary.pojo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "User_ID", nullable = false, updatable = false)
    int id;

    @Column(name = "UserFullName")
    String Name;

    @Column(name = "Username", unique = true)
    String userName;

    @Column( name = "Type_ID")
    int userTypeId;

    @Column( name = "Authentication_String", nullable = false)
    String password;

    @ManyToOne
    @JoinColumn( name = "Type_ID", referencedColumnName = "Type_ID", insertable = false, updatable = false)
    private UserType userType;
}
