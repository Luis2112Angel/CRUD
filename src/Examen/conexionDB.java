/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Angel
 */
public class conexionDB {
    
    private Connection c = null;
    private static conexionDB cx = null;
    
    public boolean execute(String sql){
        boolean res = false;
        try{
            Statement st = c.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public ResultSet executeQuery(String sql){
        ResultSet res = null;
        try{
            Statement st = c.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    private conexionDB(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Examen";
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, "postgres", "211215");
            //System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static conexionDB getInstance(){
        if(cx==null)
            cx = new conexionDB();
        return cx;
        }
}
