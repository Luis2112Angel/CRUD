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
public class Docente <T> {
    private T clave;
    private T nombre;
    private T direccion;
    private T telefono;

    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public T getNombre() {
        return nombre;
    }

    public void setNombre(T nombre) {
        this.nombre = nombre;
    }

    public T getDireccion() {
        return direccion;
    }

    public void setDireccion(T direccion) {
        this.direccion = direccion;
    }

    public T getTelefono() {
        return telefono;
    }

    public void setTelefono(T telefono) {
        this.telefono = telefono;
    }
    
    
}
