package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.model.Group;

import java.util.List;

public interface GroupDAO {

    public void insert(Group group);

    public List<Group> list(String pattem);

    public Group get(int id);

    public void delete(int id);

    public void update(Group group);
}
