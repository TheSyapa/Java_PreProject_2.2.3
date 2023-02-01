package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User getById(int id);

    void remove(int id);

    void update(User user);

    List<User> getAll();
}
