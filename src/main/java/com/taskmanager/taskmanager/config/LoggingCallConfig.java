package com.taskmanager.taskmanager.config;

import com.taskmanager.taskmanager.model.LoggingCall;
import com.taskmanager.taskmanager.model.Users;
import com.taskmanager.taskmanager.repository.LoggingCallRepository;
import com.taskmanager.taskmanager.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
@Configuration
public class LoggingCallConfig {

    @Bean
    CommandLineRunner commandLineRunner2(LoggingCallRepository loggingCallRepository,UsersRepository usersRepository) {
        return args -> {

                Users attachedUser = new Users(
                        "singh Kumar",
                        "singh56@gmail.com"
                );
                attachedUser.setCreatedOn(LocalDateTime.now());



                    LoggingCall loggingCall1 = new LoggingCall();

                    loggingCall1.setUser(attachedUser);
                    loggingCall1.setDescription("opoassjajajp");
                    loggingCall1.setCreatedOn(LocalDateTime.now());
                    loggingCall1.setContactDetails("89898aa98");
                    loggingCall1.setCustomerName("singh Kumar");


                 //   loggingCallRepository.save(loggingCall1);


        };
    }

}
