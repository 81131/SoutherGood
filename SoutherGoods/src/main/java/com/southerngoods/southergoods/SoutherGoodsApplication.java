package com.southerngoods.southergoods;

import com.southerngoods.southergoods.entity.User;
import com.southerngoods.southergoods.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class SoutherGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoutherGoodsApplication.class, args);
    }

    // Bean for password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This bean will run on startup and insert mock data
    @Bean
    CommandLineRunner run(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the table is empty
            if (userRepository.count() == 0) {
                // System Administrator Mock Data
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // Always encode passwords!
                admin.setRole("ADMIN");
                userRepository.save(admin);

                // Sales Staff Mock Data
                User sales = new User();
                sales.setUsername("sales");
                sales.setPassword(passwordEncoder.encode("sales123"));
                sales.setRole("SALES_STAFF");
                userRepository.save(sales);

                // Warehouse Staff Mock Data
                User warehouse = new User();
                warehouse.setUsername("warehouse");
                warehouse.setPassword(passwordEncoder.encode("warehouse123"));
                warehouse.setRole("WAREHOUSE_STAFF");
                userRepository.save(warehouse);

                System.out.println("Mock user data has been inserted.");
            }
        };
    }
}