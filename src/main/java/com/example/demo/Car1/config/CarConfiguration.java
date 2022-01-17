package com.example.demo.Car1.config;
import com.example.car.entity.Car;
import com.example.demo.Car1.Entity.Car1;
import com.example.demo.Car1.Entity.Owner;
import com.example.demo.Car1.Entity.User;
import com.example.demo.Car1.Repository.Car1Repository;
import com.example.demo.Car1.Repository.OwnerRepository;
import com.example.demo.Car1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class CarConfiguration {
    @Autowired
    private Car1Repository car1Repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner car(){
        return args -> {
            Owner owner1 = new Owner("hari","thapa");
            Owner owner2 = new Owner ("ram","shrestha");
            ownerRepository.saveAll(Arrays.asList(owner1,owner2));
//
            Car1 car1 = new Car1("abc","123445","blue",12000000.0, owner1);
            Car1 car2 = new Car1("abc","1234","white",12099900.0,owner2);
            Car1 car3 = new Car1("abc","12","white",12099900.0,owner2);

            car1Repository.saveAll(Arrays.asList(car1,car2,car3));
//            Optional<Car1> car = car1Repository.findById(1);
//            Optional<User> user = userRepository.findById(2);
            User user1 = new User("nitika","$2a$12$rl1as/GkSkxoZysWY4hPU.zKafs1wMYIy.y3tbxD8VYcNgiE7cZJ6","USER");
            userRepository.saveAll(Arrays.asList(user1));



        };
    }
}
