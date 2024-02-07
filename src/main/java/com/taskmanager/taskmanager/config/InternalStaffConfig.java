package com.taskmanager.taskmanager.config;
import com.taskmanager.taskmanager.repository.InternalStaffRepository;
import com.taskmanager.taskmanager.model.InternalStaff;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InternalStaffConfig {
    @Bean
    CommandLineRunner commandLineRunner1(InternalStaffRepository internalStaffRepository) {
        return args -> {
            InternalStaff internalStaff1 = new InternalStaff(
                    "emp12",
                    "piyush kumar",
                    "piyushkumarcs56e44@gmail.com"

            );
            InternalStaff internalStaff2 = new InternalStaff(
                    "emp13",
                    "Ayush Kumar",
                    "Ayushkumarc78se44@gmail.com"

            );

//            InternalStaffServiceImp internalStaffServiceImp = new InternalStaffServiceImp(internalStaffRepository);
//            internalStaffServiceImp.CreateSingle(internalStaff1);
//            internalStaffServiceImp.CreateSingle(internalStaff2);
//


        };
    }
}
