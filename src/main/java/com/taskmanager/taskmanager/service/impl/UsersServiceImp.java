package com.taskmanager.taskmanager.service.impl;

import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.service.UsersService;
import com.taskmanager.taskmanager.model.Users;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> GetAll() {
        List<Users> users = usersRepository.findAll();
        return usersRepository.findAll();
    }


    @Override
    public Users Get(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }


    @Override
    public Users CreateSingle(Users user) {
        Optional<Users> userEmail = usersRepository.findByEmail(user.getEmail());
        if(userEmail.isPresent()) {
            throw new IllegalStateException("user already present with email ");
        }
        else {
            user.setCreatedOn(LocalDateTime.now());
            usersRepository.save(user);
        }
        return user;
    }

    @Override
    public List<Users> CreateMultiple(List<Users> users) {
        List<Users> savedUsers = new ArrayList<Users>();
        for (Users user : users) {
            user.setCreatedOn(LocalDateTime.now());
            Users savedUser = usersRepository.save(user);
            savedUsers.add(savedUser);
        }
        return savedUsers;
    }


    @Override
    public String Delete(Long id) {
        if(usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return "Deleted Successfully";
        }
        else {

                throw new IllegalStateException("User with "+id + " is not present");

        }
    }

    @Override
    @Transactional
    public String Update(Long id, String name, String email) {
        Users  user = usersRepository.findById(id).orElseThrow(
                ()->new IllegalStateException(
                        "user with "+id+" Does not Exist"
                )
        );
        if(name!=null && !name.isEmpty() && !Objects.equals(user.getName(), name))
        {
            user.setName(name);
        }

        if(email!=null &&  !email.isEmpty() && !Objects.equals(user.getEmail(),email) )
        {
            if(usersRepository.findByEmail(email).isPresent())
                throw new IllegalStateException("Another User with "+email + " already present");
            user.setEmail(email);
        }
        return "Updated Successfully";

    }

    @Override
    public String DeleteAll() {
        usersRepository.deleteAll();
        return "Deleted SuccessFully";

    }

}
