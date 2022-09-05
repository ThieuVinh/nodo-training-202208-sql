package edu.hanoi.service.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "HN_USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@Data
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "groupId", nullable = false)
    private int groupId;
}
