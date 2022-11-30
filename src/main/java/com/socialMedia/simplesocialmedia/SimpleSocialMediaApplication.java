package com.socialMedia.simplesocialmedia;

import com.socialMedia.simplesocialmedia.user.User;
import com.socialMedia.simplesocialmedia.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SimpleSocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSocialMediaApplication.class, args);
	}
	@Bean
	@Profile("dev")
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
			try {
				userService.getByUsername("user1");
			} catch (Exception e) {
				for(int i = 1; i<=25;i++) {
					User user = new User();
					user.setUsername("user"+i);
					user.setDisplayName("display"+i);
					user.setPassword("Password");
					userService.save(user);
				}
			}
		};
	}

}
