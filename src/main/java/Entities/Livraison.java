package Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double poids;

    @Temporal(TemporalType.DATE)
    private Date date_start;
    private String city_start;
    private String city_end;
    private double tarif;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vehicule vehicule;

    @ManyToOne
    private RespLivraison respLivraison;

}
