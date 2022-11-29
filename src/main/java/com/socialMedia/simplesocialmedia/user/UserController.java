package com.socialMedia.simplesocialmedia.user;

import com.socialMedia.simplesocialmedia.error.ApiError;
import com.socialMedia.simplesocialmedia.response.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger log =LoggerFactory.getLogger(UserController.class);


    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)// işeme uygun cevap dönüyor

    public ResponseEntity<?> createUser(@RequestBody UserEntity user ){
        ApiError error=new ApiError(400,"Validation error","/api/users");
        Map<String,String > validationErrors=new HashMap<>();
        String username=user.getUsername();
        String displayName=user.getDisplayName();

        if (username==null && username.isEmpty()){
            validationErrors.put("username","Username can not be null.");
        }
        if (displayName==null && displayName.isEmpty()){
            validationErrors.put("displayName"," can not be null.");
        }
        if (validationErrors.size()>0){
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }


        userService.save(user);
        return ResponseEntity.ok(new GenericResponse("USER CREATED"));

    }
}
