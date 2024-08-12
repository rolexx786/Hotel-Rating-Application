package com.usermicro.services;

import com.usermicro.entity.User;

import java.util.List;

public interface UserServices {

    User createUser(User user);

    List<User> getUsers();

    User getUserById(String id);

    User updateUser(User user, String id);

    void deleteUser(String id);

}
