package Dao.Manager;

import Entities.Admin;
import Entities.Manager;

import java.util.List;

public interface IManagerDao {

    void add(Manager manager);

    void update(String email, String login,Long id);

    void delete(Long id);

    Manager findOne(Long id);

    List<Manager> findAll();

}
