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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

    @OneToMany(mappedBy = "manager")
    private List<RespLivraison> respLivraisons;
}
