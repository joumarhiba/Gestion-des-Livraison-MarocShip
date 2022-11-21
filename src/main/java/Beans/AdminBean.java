package Beans;

import Dao.AdminDao;
import Entities.User;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.SQLException;

@ManagedBean(name = "adminbean")
public class AdminBean implements Serializable {
    private User user;
    AdminDao adminDao;

   /* public User getAdmin(){
        if(this.user ==null){
            this.user = new User();
        }
        return user;
    }
    */
    public void setAdmin(User user){
        this.user = user;
    }

    public void createAdmin() throws SQLException{
        adminDao.createAdmin(this.user);
    }

}
