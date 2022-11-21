package Dao.Chauffeur;

import Entities.Chauffeur;
import Entities.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;


public class ChauffeurDaoImp implements IChauffeurDao {


    final private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;
    private Session session;

    public ChauffeurDaoImp() {
        this.registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(this.registry).buildMetadata().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    @Override
    public void add(Chauffeur chauffeur) {
        this.session.beginTransaction();
        try {

            this.session.persist(chauffeur);

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
        Chauffeur chauffeur = this.findOne(id);
        try {
            this.session.beginTransaction();
            chauffeur.setEmail(email);
            chauffeur.setLogin(login);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.session.getTransaction().commit();
            this.session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Chauffeur chauffeur;
        try{
            this.session.beginTransaction();
            chauffeur = this.findOne(id);
            this.session.delete(chauffeur);
        }catch (Exception e){
            this.session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            this.session.getTransaction().commit();
            this.session.close();
        }
    }

    @Override
    public Chauffeur findOne(Long id) {
        Chauffeur chauffeur = null;
        try{
            chauffeur  = this.session.get(Chauffeur.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.session.close();
            return chauffeur;
        }
    }

    @Override
    public List<Chauffeur> findAll() {

        Query query = this.session.createQuery("from Chauffeur");

        List<Chauffeur> chauffeurs = query.getResultList();

        return chauffeurs;
    }


}
