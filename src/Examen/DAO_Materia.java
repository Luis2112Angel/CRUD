/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

/**
 *
 * @author Luis Angel
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_Materia implements IDAOGeneral<Materia>{
    conexionDB con = conexionDB.getInstance();
    
    @Override
    public boolean guardar(Materia materia){
        boolean res = true;
        String sql = "INSERT INTO materias (clave,nombre,creditos) VALUES ('" +
                materia.getClave() + "','" +
                materia.getCreditos() + "','" +
                materia.getNombre() + "')";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Guardado con exito");
        return res;
    }
    
    @Override
    public boolean eliminar(Materia materia){
        boolean res = true;
        String sql = "DELETE FROM materias WHERE clave ='"+materia.getClave()+"'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Eliminado con exito");
        return res;
    }
    
    @Override
    public boolean modificar(Materia materias){
        boolean res = true;
        String sql = "UPDATE materias SET " + 
                "nombre ='" + materias.getNombre() + "'" + 
                "creditos ='" + materias.getCreditos() + "'" + 
                "WHERE clave ='" + materias.getClave() + "'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Modificado con exito");
        return res;
    }
    
    
    @Override
    public Materia buscarByID(String clave){
        Materia d = new Materia();
        String sql = "SELECT * FROM materias WHERE clave ='"+clave+"'";
        con.execute(sql);
        ResultSet rs = con.executeQuery(sql);
        try {
            while(rs.next()){
             d.setClave(rs.getString("clave"));
             d.setNombre(rs.getString("nombre"));
             d.setCreditos(rs.getString("creditos"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
