package com.socialMedia.simplesocialmedia.user;

import com.socialMedia.simplesocialmedia.error.ApiError;
import com.socialMedia.simplesocialmedia.response.GenericResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    public GenericResponse createUser(@Valid @RequestBody User user ){

        userService.save(user);
        return new GenericResponse("USER CREATED");

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  ApiError handleValidationException(MethodArgumentNotValidException exception){
        ApiError error=new ApiError(400,"Validation error","/api/users");
        Map<String,String > validationErrors=new HashMap<>();
        for( FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;

    }
}
