package Dao;

import Entities.User;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

@ManagedBean
public class AdminDao {
    private EntityManager em;
    private EntityTransaction et;

    protected EntityManager getEm(){
        if(em == null){
            this.em = Persistence.createEntityManagerFactory("postgres").createEntityManager();
        }
        return  em;
    }

    private EntityTransaction getEt(){
        et = getEm().getTransaction();
        return  et;
    }

    public User createAdmin(User entity) throws SQLException{
        if(!getEt().isActive()){
            et.begin();
        }
        try{
            getEm().persist(entity);
            getEm().flush();
            getEt().commit();
            return  entity;

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            if(!getEt().isActive()){
                et.begin();
            }
            getEt().rollback();
            throw new SQLException(ex.getMessage());
        }

    }
}
