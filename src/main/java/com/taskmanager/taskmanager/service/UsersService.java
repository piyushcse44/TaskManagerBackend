package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.Users;

import java.util.List;

public interface UsersService {
    public List<Users> GetAll();
    public Users Get(Long id);
    public Users CreateSingle(Users user);
    public List<Users> CreateMultiple(List<Users> users);
    public String Delete(Long id);
    public String Update(Long id,String name,String email);
    public String DeleteAll();
}
