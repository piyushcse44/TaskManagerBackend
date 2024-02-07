package com.taskmanager.taskmanager.config;
import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.model.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UsersConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository){
        return args ->{
            Users user1 =new Users(
                    "piyush",
                    "piyushkumarcse44@gmail.com"

            );
            Users user2 =new Users(
                    "Ayush",
                    "AyushKumar44@gmail.com"

            );
            Users user3 =new Users(
                    "Aryan",
                    "AryanRaj3090@gmail.com"

            );
            user1.setCreatedOn(LocalDateTime.now());
            user2.setCreatedOn(LocalDateTime.now());
            user3.setCreatedOn(LocalDateTime.now());

//            usersRepository.saveAll(
//                    List.of(
//                            user1,
//                            user2,
//                            user3
//                    )
//            );

        };
    }

}
