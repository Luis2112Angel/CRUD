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
public class DocenteGUI extends GUIGeneral{
    
    IDAOGeneral docentes = Creador_DAO.getObjetoDao(Creador_DAO.DAOTYPE.DOCENTES);
    
    public DocenteGUI(){
        v1.setText("Clave");
        v2.setText("Nombre");
        v3.setText("Direccion");
        v4.setText("Telefono");
        v5.setVisible(false);
        txt5.setVisible(false);
    }

    @Override
    public void guardar() {
        Docente d = new Docente();
        d.setClave(txt1.getText());
        d.setNombre(txt2.getText());
        d.setDireccion(txt3.getText());
        d.setTelefono(txt4.getText());
        docentes.guardar(d);
        limpiar();
    }

    @Override
    public void eliminar() {
        docentes.eliminar(docentes.buscarByID(txt1.getText()));
        limpiar();
    }

    @Override
    public void consultar() {
        Docente d = (Docente)docentes.buscarByID(txt1.getText());
        if(d.getNombre()!=null){
            txt2.setText(d.getNombre().toString());
            txt3.setText(d.getDireccion().toString());
            txt4.setText(d.getTelefono().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No existe el docente");
            limpiar();
        }
    }

    @Override
    public void modificar() {
        Docente d = new Docente();
        d.setClave(txt1.getText());
        d.setNombre(txt2.getText());
        d.setDireccion(txt3.getText());
        d.setTelefono(txt4.getText());
        docentes.modificar(d);
        limpiar();
    }

    private void limpiar(){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
    }
    
}
