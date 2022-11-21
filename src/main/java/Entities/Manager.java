package Entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "manager")
public class Manager extends User {



    @OneToMany(mappedBy = "manager")
    private List<Livraison> livraisons;
}
