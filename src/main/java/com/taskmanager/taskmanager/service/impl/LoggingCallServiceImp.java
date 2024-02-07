package com.taskmanager.taskmanager.service.impl;

import com.taskmanager.taskmanager.model.Users;
import com.taskmanager.taskmanager.repository.LoggingCallRepository;
import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.service.LoggingCallService;
import com.taskmanager.taskmanager.model.LoggingCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class LoggingCallServiceImp implements LoggingCallService {


    @Autowired
    private final LoggingCallRepository loggingCallRepository;
    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    public LoggingCallServiceImp(LoggingCallRepository loggingCallRepository, UsersRepository usersRepository) {
        this.loggingCallRepository = loggingCallRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public List<LoggingCall> GetAll() {
        return loggingCallRepository.findAll();
    }

    @Override
    public LoggingCall Get(Long logId) {
        return loggingCallRepository.findById(logId).orElseThrow(
                () ->new IllegalStateException("Log with "+logId+" is empty"));
    }

    @Override
    public LoggingCall CreateSingle(LoggingCall loggingCall) {

        loggingCall.getUser().setCreatedOn(LocalDateTime.now());
        Users user= loggingCall.getUser();
        if(user.getId()!=null && usersRepository.existsById(user.getId()))
            throw new IllegalStateException("User with userid:"+user.getId()+" Already exists");
        if(usersRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("User with email:"+user.getEmail()+" Already Present");
        loggingCallRepository.save(loggingCall);
        return loggingCall;
    }

    @Override
    public LoggingCall CreateSingleWithId(Long id,LoggingCall loggingCall) {

        Users user = usersRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("User with id :"+id+" is not registered")
        );

        loggingCall.setUser(user);
        loggingCall.setCreatedOn(LocalDateTime.now());
        loggingCallRepository.save(loggingCall);
        return loggingCall;
    }

    @Override
    public List<LoggingCall> CreateMultiple(List<LoggingCall> loggingCalls) {
        return null;
    }

    @Override
    public String Delete(Long id) {

        if(loggingCallRepository.existsById(id))
        {
            loggingCallRepository.deleteById(id);
            return "Deleted SuccessFully";
        }
        throw new IllegalStateException("No Log call is registered with id:"+id);

    }

    @Override
    public String DeleteAll() {
        loggingCallRepository.deleteAll();
        return "Deleted SuccessFully";
    }
}
