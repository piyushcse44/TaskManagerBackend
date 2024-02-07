package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.service.UsersService;
import com.taskmanager.taskmanager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UsersController {

    @Autowired
    private final UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping
    public List<Users> GetALlUser()
    {
        return  usersService.GetAll();
    }

    @GetMapping(path = "{id}")
    public Users GetUser(@PathVariable Long id)
    {
        return usersService.Get(id);
    }

    @PostMapping
    public Users CreateUser(@RequestBody Users user)
    {
        return usersService.CreateSingle(user);
    }

    @PutMapping(path="{id}")
    public String UpdateUser(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        return usersService.Update(id,name,email);
    }

    @DeleteMapping
    public String DeleteAllUser()
    {
        return usersService.DeleteAll();
    }

    @DeleteMapping(path = "{id}")
    public String DeleteUser(@PathVariable Long id)
    {
        return usersService.Delete(id);
    }

}

