package base.user;

import base.security.CurrentUser;
import base.security.WebDevice;
import base.security.jwt.JwtAuthenticationResponse;
import base.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Return only logged in user
    
    @GetMapping
    public UserDetails getCurrentUser(@CurrentUser UserDetails currentUser) {
        return currentUser;
    }

    @RequestMapping("/all")
    public List<User> getUsers(@CurrentUser UserDetails currentUser) {
        ArrayList<User> users = new ArrayList<User>();
//        if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            for (User u : userRepository.findAll()) {
                users.add(u);
            }
//        }
        return users;
    }

    @PostMapping
    public User create(@Valid @RequestBody User reqUser) {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setEmail(reqUser.getEmail());
        user.setFirstName(reqUser.getFirstName());
        user.setLastName(reqUser.getLastName());
        user.setPassword(new BCryptPasswordEncoder().encode(reqUser.getPassword()));
        user.setMajor(reqUser.getMajor());
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        // ADMIN Route
        userRepository.delete(id);
    }

    @PutMapping("{id}")
    public User update(@PathVariable Long id, @RequestBody User reqUser) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return null;
        } else {
            user.setEmail(reqUser.getEmail());
            user.setFirstName(reqUser.getFirstName());
            user.setLastName(reqUser.getLastName());
            user.setEmail(reqUser.getEmail());
            user.setPassword(new BCryptPasswordEncoder().encode(reqUser.getPassword()));
            user.setMajor(reqUser.getMajor());
            return userRepository.save(user);
        }
    }

    @PostMapping("/valid")
    public ResponseEntity<?> validateUser(@RequestBody User inUser) {
        User user = userRepository.findByEmail(inUser.getEmail());
        if (user != null && (new BCryptPasswordEncoder())
                .matches(inUser.getPassword(), user.getPassword())) {
            String token = jwtTokenUtil.generateToken(user, new WebDevice());
            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}