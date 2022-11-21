package Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @OneToOne
    private Chauffeur chauffeur;



}
