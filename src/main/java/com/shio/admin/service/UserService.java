package com.shio.admin.service;

import com.shio.admin.DTO.TokenDTO;
import com.shio.admin.domain.User;
import com.shio.admin.persistence.UserRepository;
import com.shio.admin.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.shio.admin.security.SecurityUtils.HEADER_STRING;
import static com.shio.admin.security.SecurityUtils.TOKEN_PREFIX;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User register(User userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setAdmin(userDTO.isAdmin());
        user.setSubsidiary(userDTO.getSubsidiary());
        return userRepository.save(user);
    }

    public User update(User userDTO) {
        User user = userRepository.findById(userDTO.getId()).get();
        if (userDTO.getUsername() != null && !userDTO.getUsername().isEmpty()) {
            user.setUsername(userDTO.getUsername());
        }
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        return userRepository.save(user);
    }

    public TokenDTO authenticate(User userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        TokenDTO tokenDTO = new TokenDTO();
        if (user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
//            tokenDTO.setToken(TOKEN_PREFIX + " " + SecurityUtils.generateToken(userDTO.getUsername()));
            tokenDTO.setToken(SecurityUtils.generateToken(userDTO.getUsername(), user.isAdmin()
                    , user.getSubsidiary()));
        }
        return tokenDTO;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
