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
public class Creador_DAO {
 
    public enum DAOTYPE {
        MATERIAS, ALUMNOS, DOCENTES;
    }
    
    public static IDAOGeneral getObjetoDao (DAOTYPE type){
        IDAOGeneral dao = null;
        switch(type){
            case MATERIAS:
                dao = new DAO_Materia();
                break;
            case ALUMNOS:
                dao = new DAO_Alumno();
                break;
            case DOCENTES:
                dao = new DAO_Docente();
                    break;
            default:
                throw new IllegalArgumentException("No soportado");
        }
        return dao;
    }
}
