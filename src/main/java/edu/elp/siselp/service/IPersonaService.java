package edu.elp.siselp.service;

import edu.elp.siselp.entity.Persona;

import java.util.List;

public interface IPersonaService {

    //Listar personas
    List<Persona> listaPersonas();

    //Buscar persona por su dni
    Persona obtenerPersonaByDni(String dni);


    //Tarea
    //1: Listar estudiantes
    //2: Listar docentes
    //3: Luistar administrativos
    //4: Buscar estudiante por codigo
    //Fecha entrega:26 de abril hasta 11:59 pm
}
