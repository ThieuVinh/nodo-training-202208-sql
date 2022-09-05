package edu.hanoi.jazz.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@javax.persistence.Entity
@Table(name="HN_USER",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User implements Comparable<User>{
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
    @Column(name = "groupId")
    private Group group;

    public User() {

    }

    public User(String username, String password, String email, int age, Group group) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.group = group;
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

    public Group getGroup() {
        return group;
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

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public int compareTo(User other) {
        return age - other.age;
    }
}
