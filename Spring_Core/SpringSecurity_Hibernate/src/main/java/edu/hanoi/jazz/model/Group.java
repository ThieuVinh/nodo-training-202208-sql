package edu.hanoi.jazz.model;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name="HN_GROUP",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="groupId")
    private List<User> users;

    public Group() {

    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
