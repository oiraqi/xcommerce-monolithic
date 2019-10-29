package ma.aui.sse.it.xcommerce.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.aui.sse.it.xcommerce.monolithic.data.dtos.User;
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
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        return "Authenticated!";
    }

    @PostMapping("/create")
    public User create(@RequestBody User dto) {
        if (dto.getPassword() == null || dto.getPassword() != dto.getPasswordConfirmation()
                || dto.getEmailAddress() == null || dto.getEmailAddress() != dto.getEmailAddressConfirmation())
            throw new RuntimeException();

        userService.create(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress(), dto.getAddress());

        return new User(dto.getUsername(), dto.getFirstName(), dto.getLastName(), dto.getEmailAddress(),
                dto.getAddress());
    }
}