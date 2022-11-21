import Entities.Admin;
import helpers.HashingPassword;

public class Main extends HibernateUtil {
    public static void main(String[] args)  {


        Admin admin = new Admin();
        HashingPassword hashingPwd = new HashingPassword();
        String password = "abcd1234";
        String hashedPwd = hashingPwd.hashingPassword(password);
        admin.setEmail("admin@gmail.com");
        admin.setLogin("adminMarocShip");
        admin.setRole(0);
        admin.setPassword(password);
        if(admin.getPassword()) {
            admin.setPassword(hashedPwd);
            session.persist(admin);
            transaction.commit();
        }
        else{
            transaction.rollback();
        }
        session.close();
        sessionFactory.close();

    }
}
