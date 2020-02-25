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
public class DAO_Docente implements IDAOGeneral<Docente>{
    conexionDB con = conexionDB.getInstance();
    
    @Override
    public boolean guardar(Docente docentes){
        boolean res = true;
        String sql = "INSERT INTO docentes (clave,nombre,direccion, telefono) VALUES ('" +
                docentes.getClave() + "','" +
                docentes.getNombre() + "','" +
                docentes.getDireccion() + "','" +
                docentes.getTelefono() + "')";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Guardado con exito");
        return res;
    }
    
    @Override
    public boolean eliminar(Docente docentes){
        boolean res = true;
        String sql = "DELETE FROM docentes WHERE clave ='"+docentes.getClave()+"'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Eliminado con exito");
        return res;
    }
    
    @Override
    public boolean modificar(Docente docentes){
        boolean res = true;
        String sql = "UPDATE materias SET " + 
                "nombre ='" + docentes.getNombre() + "'" + 
                "direccion ='" + docentes.getDireccion() + "'" + 
                "telefono ='" + docentes.getTelefono() + "'" + 
                "WHERE clave ='" + docentes.getClave() + "'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Modificado con exito");
        return res;
    }
    
    
    @Override
    public Docente buscarByID(String clave){
        Docente d = new Docente();
        String sql = "SELECT * FROM docentes WHERE clave ='"+clave+"'";
        con.execute(sql);
        ResultSet rs = con.executeQuery(sql);
        try {
            while(rs.next()){
             d.setClave(rs.getString("clave"));
             d.setNombre(rs.getString("nombre"));
             d.setDireccion(rs.getString("direccion"));
             d.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
}
