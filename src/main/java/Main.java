import Dao.Admin.AdminDaoImp;
import Dao.Admin.IAdminDao;
import Entities.Manager;
import helpers.HashingPassword;

public class Main {
    public static void main(String[] args) {


        IAdminDao adminDao = new AdminDaoImp();
        Manager manager = new Manager();
        manager.setEmail("amine@mesbahi.com");

        HashingPassword hashingPassword = new HashingPassword();
        String pass = hashingPassword.hashingPassword("amine1234");
        manager.setPassword(pass);
        manager.setLogin("aminMsb");

        adminDao.addManager(manager);


    }
}
