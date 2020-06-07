package model;

import model.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * The type Dao.
 */
public abstract class DAO {
    private Connection Conn  =null ;

    /**
     * Instantiates a new Dao.
     */
    DAO(){
        try{
            Connection Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
    }

    /**
     * Sets data.
     */
//public abstract void find(String catergorie, String key_word);
    public abstract void setData();
}