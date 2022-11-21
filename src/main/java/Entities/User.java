package Entities;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String email;
    private String login;
    private String password;

    public boolean getPassword() {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])"
                + ".{8,20}$";

        Pattern pattern= Pattern.compile(regex);
        Matcher m = pattern.matcher(password);
        if(m.matches()) {

            return true;
        }else {
            System.out.println("this password "+password+" not validate");
            return false;
        }
    }
}
