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
public class MateriaGUI extends GUIGeneral{
    
    IDAOGeneral materias = Creador_DAO.getObjetoDao(Creador_DAO.DAOTYPE.MATERIAS);
    
    public MateriaGUI(){
        v1.setText("Clave");
        v2.setText("Nombre");
        v3.setText("Creditos");
        v4.setVisible(false);
        v5.setVisible(false);
        txt4.setVisible(false);
        txt5.setVisible(false);
    }

    @Override
    public void guardar() {
        Materia a = new Materia();
        a.setClave(txt1.getText());
        a.setNombre(txt2.getText());
        a.setCreditos(txt3.getText());
        materias.guardar(a);
        limpiar();
    }

    @Override
    public void eliminar() {
        materias.eliminar(materias.buscarByID(txt1.getText()));
        limpiar();
    }

    @Override
    public void consultar() {
        Materia d = (Materia)materias.buscarByID(txt1.getText());
        if(d.getNombre()!=null){
            txt2.setText(d.getNombre().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No existe la materia");
            limpiar();
        }
    }

    @Override
    public void modificar() {
        Materia a = new Materia();
        a.setClave(txt1.getText());
        a.setNombre(txt2.getText());
        a.setCreditos(txt3.getText());
        materias.modificar(a);
        limpiar();
    }

    private void limpiar(){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
    }
    
}
