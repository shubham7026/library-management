package com.ind.lms.restcontroller;


import com.ind.lms.entity.Person;
import com.ind.lms.entity.User;
import com.ind.lms.repository.interfaces.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.yml")
public class UserController {

    private final IUserRepository iUserRepository;
    @Value("${spring.application.name}")
    private static String greeting ;
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        iUserRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id ){
        System.out.println(greeting);
        User user = iUserRepository.findById(id).orElse(null);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
