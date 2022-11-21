package Entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "respLivraison")
public class RespLivraison extends User{

    @ManyToOne(cascade = CascadeType.ALL)
    private Manager manager;

    @OneToMany(mappedBy = "respLivraison")
    private List<Livraison> livraisons;

}
