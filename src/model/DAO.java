package model;

import model.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO {
    private Connection Conn  =null ;
    DAO(){
        try{
            Connection Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
    }
    //public abstract void find(String catergorie, String key_word);
    public abstract void setData();
}