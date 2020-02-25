/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis Angel
 */
public class AlumnoGUI extends GUIGeneral {
    
    IDAOGeneral alumnos = Creador_DAO.getObjetoDao(Creador_DAO.DAOTYPE.ALUMNOS);
        
     public AlumnoGUI(){
        v1.setText("Matricula");
        v2.setText("Nombre");
        v3.setText("Direccion");
        v4.setText("Telefono");
        v5.setText("Semestre");
    }

    @Override
    public void guardar() {
        Alumno a = new Alumno();
        a.setMatricula(txt1.getText());
        a.setNombre(txt2.getText());
        a.setDireccion(txt3.getText());
        a.setTelefono(txt4.getText());
        a.setSemestre(txt5.getText());
        alumnos.guardar(a);
        limpiar();
    }

    @Override
    public void eliminar() {
        alumnos.eliminar(alumnos.buscarByID(txt1.getText()));
        limpiar();
    }

    @Override
    public void consultar() {
        Alumno a = (Alumno)alumnos.buscarByID(txt1.getText());
        if(a.getNombre()!=null){
            txt2.setText(a.getNombre().toString());
            txt3.setText(a.getDireccion().toString());
            txt4.setText(a.getTelefono().toString());
            txt5.setText(a.getSemestre().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No existe el alumno");
            limpiar();
        }
    }

    @Override
    public void modificar() {
        Alumno a = new Alumno();
        a.setMatricula(txt1.getText());
        a.setNombre(txt2.getText());
        a.setDireccion(txt3.getText());
        a.setTelefono(txt4.getText());
        a.setSemestre(txt5.getText());
        alumnos.modificar(a);
        limpiar();
    }

    private void limpiar(){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
    }
    
}
