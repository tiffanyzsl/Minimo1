package org.example;

import java.util.List;

public interface MathManager {
    void requerirOperacion(String idAlumno, String idInstituto, String expresion);
    Operacion procesarOperacion();
    List<Operacion> listarOperacionesInstituto(String idInstituto);
    List<Operacion> listarOperacionesAlumno(String idAlumno);
    List<Instituto> listarInstitutosOrdenados();
}