package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public void update(long userId, String password, String newPassword,
        String firstName, String lastName, String emailAddress, String address) {      
        User user = userRepository.findById(userId).get();
        if (password != null && (newPassword == null ||
            !(new BCryptPasswordEncoder().encode(password).equals(user.getPassword())))) {
            return;
        }

        if (newPassword != null)
            user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        if (firstName != null)
            user.setFirstName(firstName);
        if (lastName != null)
            user.setLastName(lastName);
        if (emailAddress != null)
            user.setEmailAddress(emailAddress);
        if (address != null)
            user.setAddress(address);
        
        userRepository.save(user);
    }
}