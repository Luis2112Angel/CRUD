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
public class Alumno <T> {
    private T matricula;
    private T nombre;
    private T direccion;
    private T telefono;
    private T semestre;

    public T getMatricula() {
        return matricula;
    }

    public void setMatricula(T matricula) {
        this.matricula = matricula;
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

    public T getSemestre() {
        return semestre;
    }

    public void setSemestre(T semestre) {
        this.semestre = semestre;
    }
    
    
}
