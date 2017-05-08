package base.security.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;

@Entity
@Table(name = "users") // 'user' is a keyword in Postgres
public class User implements Serializable {

    private static final String TEST_ADMIN = "admin@admin.com";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "Password is required.")
    private String password;

    //Using Timestamp. Need to change eventually
    public User(){
        this.id = System.currentTimeMillis();
    }

    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.id = user.id;
    }

    public Long getId() {
        return id;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Setters
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
