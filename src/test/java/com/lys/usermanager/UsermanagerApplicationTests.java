package com.lys.usermanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermanagerApplicationTests {

    @Test
    public void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches("123456", "$2a$10$.XNb3CuDICFY4nRy6089/OeF53ia1egGhUu/J0b3eWI8IOJXqP3P2");
        boolean matches2 = passwordEncoder.matches("123456", "$2a$10$BNJG5Xd80Q8EqGZ8KbpK.O56EaPaEpeAGFf9WV445ukQEfLXDVnUG");
        System.out.println(matches);
        System.out.println(matches2);
    }

}
