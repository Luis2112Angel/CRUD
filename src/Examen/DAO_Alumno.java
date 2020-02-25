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
public class DAO_Alumno implements IDAOGeneral<Alumno>{
    conexionDB con = conexionDB.getInstance();
    
    @Override
    public boolean guardar(Alumno alumnos){
        boolean res = true;
        String sql = "INSERT INTO alumnos (matricula,nombre,direccion,telefono,semestre) VALUES ('" +
                alumnos.getMatricula() + "','" +
                alumnos.getNombre() + "','" +
                alumnos.getDireccion() + "','" +
                alumnos.getTelefono() + "','" +
                alumnos.getSemestre() + "')";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Guardado con exito");
        return res;
    }
    
    @Override
    public boolean eliminar(Alumno alumnos){
        boolean res = true;
        String sql = "DELETE FROM alumnos WHERE matricula"
                + " ='"+alumnos.getMatricula()+"'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Eliminado con exito");
        return res;
    }
    
    @Override
    public boolean modificar(Alumno alumnos){
        boolean res = true;
        String sql = "UPDATE alumnos SET " + 
                "nombre ='" + alumnos.getNombre() + "'," +
                "direccion = '" + alumnos.getDireccion() + "'," +
                "telefono = '" + alumnos.getTelefono() + "'," +
                "semestre = '" + alumnos.getSemestre() + "'" +
                "WHERE matricula ='" + alumnos.getMatricula() + "'";
        con.execute(sql);
        JOptionPane.showMessageDialog(null, "Modificado con exito");
        return res;
    }
    
    
    @Override
    public Alumno buscarByID(String clave){
        Alumno d = new Alumno();
        String sql = "SELECT * FROM alumnos WHERE matricula ='"+clave+"'";
        con.execute(sql);
        ResultSet rs = con.executeQuery(sql);
        try {
            while(rs.next()){
             d.setMatricula(rs.getString("matricula"));
             d.setNombre(rs.getString("nombre"));
             d.setDireccion(rs.getString("direccion"));
             d.setTelefono(rs.getString("telefono"));
             d.setSemestre(rs.getString("semestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
}
