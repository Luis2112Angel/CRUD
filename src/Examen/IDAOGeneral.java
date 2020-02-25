/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

//import java.util.List;

/**
 *
 * @author Luis Angel
 */
public interface IDAOGeneral<T>{
    public boolean guardar(T valor);
    public boolean eliminar(T valor);
    public boolean modificar(T valor);
    //public List<T> buscarAll();
    public T buscarByID(String valor);
}
