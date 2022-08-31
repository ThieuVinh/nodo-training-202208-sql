package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.model.Group;
import edu.hanoi.jazz.model.User;

import java.util.List;

public interface UserDAO {
    public void insert(User user);

    public List<User> list(Integer group);

    public User get(String username);

    public void delete(String username);

    public void update(User user);
}
