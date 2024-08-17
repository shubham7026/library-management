package com.ind.lms.restcontroller;


import com.ind.lms.entity.User;
import com.ind.lms.repository.interfaces.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("userController")
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final IUserRepository iUserRepository;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        iUserRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id ){
        User user = iUserRepository.findById(id).orElse(null);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
