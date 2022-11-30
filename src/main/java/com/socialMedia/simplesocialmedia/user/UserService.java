package com.socialMedia.simplesocialmedia.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    //  @Autowired  bir class da sadece bir constuructor varsa gerek yok
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }




    public void save(User user) {
        String encryptedPassword=this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);

    }

    public void getByUsername(String user1) {
    }
}
