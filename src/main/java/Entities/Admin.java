package Entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@ManagedBean(name = "admin")
public class Admin extends User{

}
