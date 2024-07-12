package com.zagado.sysarch.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagado.sysarch.model.User;
import com.zagado.sysarch.repository.UserRepository;
import com.zagado.sysarch.service.UserService;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class UserController {


    @Autowired
    UserRepository repo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return repo.findAll();
    }


    @PostMapping("/register")
    public String register(User user){
        repo.save(user);
        return "Registration Successful.";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
    
        return userService.login(username, password);
    }

    static class UserLoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}