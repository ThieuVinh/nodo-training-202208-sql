package edu.hanoi.jazz.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@javax.persistence.Entity
@Table(name="HN_USER",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "groupId", nullable = false)
    private int groupId;

    public User() {

    }

    public User(String username, String password, String email, int age, int groupId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
