package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Authority;
import ma.aui.sse.it.xcommerce.monolithic.data.entities.User;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.AuthorityRepository;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    public void create(String username, String password, String firstName,
        String lastName, String emailAddress, String address) {
        
        User user = new User(username, password, firstName, lastName, emailAddress, address);
        Authority authority = new Authority(username, "ROLE_USER");
        userRepository.save(user);
        authorityRepository.save(authority);
    }
}