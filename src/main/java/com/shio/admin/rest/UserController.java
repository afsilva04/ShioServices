package com.shio.admin.rest;

import com.shio.admin.DTO.TokenDTO;
import com.shio.admin.domain.User;
import com.shio.admin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/sign-up")
    public User register(@RequestBody User userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public TokenDTO authenticate(@RequestBody User userDTO, HttpServletResponse res) {
//        if (userService.authenticate(userDTO)) {
//            res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + SecurityUtils.generateToken(userDTO.getUsername()));
//        }
        return userService.authenticate(userDTO);
    }

    @PutMapping()
    public User update(@RequestBody User userDTO) {
        return userService.update(userDTO);
    }

}
