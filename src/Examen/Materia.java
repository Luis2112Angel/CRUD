
package Examen;


public class Materia <T>{
  private T clave;
  private T nombre;
  private T creditos;

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

    public T getCreditos() {
        return creditos;
    }

    public void setCreditos(T creditos) {
        this.creditos = creditos;
    }


}
