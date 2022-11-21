package Dao.Manager;

import Entities.Admin;
import Entities.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;


public class ManagerDaoImp implements IManagerDao {


    final private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;
    private Session session;

    public ManagerDaoImp() {
        this.registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(this.registry).buildMetadata().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    @Override
    public void add(Manager manager) {
        this.session.beginTransaction();
        try {

            this.session.persist(manager);

        }catch (Exception e){

            this.session.getTransaction().rollback();
            System.out.println(e);

        }finally {

            this.session.getTransaction().commit();
            StandardServiceRegistryBuilder.destroy( registry );

        }
    }

    @Override
    public void update(String email, String login,Long id) {
        Manager manager = this.findOne(id);
        try {
            this.session.beginTransaction();
            manager.setEmail(email);
            manager.setLogin(login);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.session.getTransaction().commit();
            this.session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Manager manager;
        try{
            this.session.beginTransaction();
            manager = this.findOne(id);
            this.session.delete(manager);
        }catch (Exception e){
            this.session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            this.session.getTransaction().commit();
            this.session.close();
        }
    }

    @Override
    public Manager findOne(Long id) {
        Manager manager = null;
        try{
            manager  = this.session.get(Manager.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.session.close();
            return manager;
        }
    }

    @Override
    public List<Manager> findAll() {

        Query query = this.session.createQuery("from Manager");

        List<Manager> managers = query.getResultList();

        return managers;
    }


}
