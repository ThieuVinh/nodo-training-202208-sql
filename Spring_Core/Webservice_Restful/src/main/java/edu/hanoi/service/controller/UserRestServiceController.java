package edu.hanoi.service.controller;

import edu.hanoi.service.dao.GroupDAO;
import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestServiceController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private GroupDAO groupDAO;

    @GetMapping(value = "/list/users")
    public List<User> listUser() {
        return userDAO.list();
    }

    @GetMapping(value = "/list/groups")
    public Group[] listGroup() {
        return groupDAO.list().toArray(new Group[0]);
    }

    @PostMapping(value = "/add/user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        return userDAO.insert(user);
    }

    @GetMapping(value = "/get/user/{name}")
    public User getUser(@PathVariable("name") String name) {
        return userDAO.get(name);
    }

    @GetMapping(value = "/delete/user/{name}")
    public void delUser(@PathVariable("name") String name) {
        userDAO.delete(name);
    }

    @PutMapping(value = "/update/user")
    public void updateUser(@RequestBody User user) {
        userDAO.update(user);
    }

}
