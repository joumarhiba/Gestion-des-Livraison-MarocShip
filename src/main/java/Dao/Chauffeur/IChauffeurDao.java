package Dao.Chauffeur;

import Entities.Chauffeur;
import Entities.Manager;

import java.util.List;

public interface IChauffeurDao {

    void add(Chauffeur chauffeur);

    void update(String email, String login,Long id);

    void delete(Long id);

    Chauffeur findOne(Long id);

    List<Chauffeur> findAll();

}
