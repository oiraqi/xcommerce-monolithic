package ma.aui.sse.it.xcommerce.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.aui.sse.it.xcommerce.monolithic.data.dtos.User;
import ma.aui.sse.it.xcommerce.monolithic.security.JwtHelper;
import ma.aui.sse.it.xcommerce.monolithic.services.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody User dto) {        
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        return JwtHelper.generateToken(authentication);
    }

    @PostMapping("/admin")
    public boolean createAdmin(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createAdmin(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress(), dto.getAddress());
        return true;
    }

    @PostMapping
    public boolean createUser(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createUser(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress(), dto.getAddress());
        return true;
    }

    @PatchMapping("/{userId}")
    public User update(@PathVariable("userId") long userId, @RequestBody User dto) {
        if (userId < 1)
            throw new RuntimeException();

        userService.update(userId, dto.getPassword(), dto.getNewPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress(), dto.getAddress());

        return new User(dto.getUsername(), null, dto.getFirstName(), dto.getLastName(), dto.getEmailAddress(),
                dto.getAddress());
    }

    private boolean check(User dto) {
        return (dto.getUsername() != null && dto.getPassword() != null && dto.getFirstName() != null
                && dto.getLastName() != null && dto.getEmailAddress() != null && dto.getAddress() != null);
    }
}