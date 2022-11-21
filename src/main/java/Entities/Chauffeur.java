package Entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "chauffeur")
public class Chauffeur extends  User{

    private double kilometrage;
    private double prime;

    @OneToOne(fetch = FetchType.EAGER)
    private Vehicule vehicule;


}
