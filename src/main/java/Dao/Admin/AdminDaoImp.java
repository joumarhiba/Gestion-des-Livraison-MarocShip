package Dao.Admin;

import Entities.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class AdminDaoImp implements IAdminDao{


    final private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;
    private Session session;



    public AdminDaoImp() {
        this.registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(this.registry).buildMetadata().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }


}
