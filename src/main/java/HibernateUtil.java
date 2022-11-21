import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

    static SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
   static Session session = sessionFactory.openSession();
   static Transaction transaction = session.beginTransaction();
}
