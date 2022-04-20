package edu.elp.siselp.service;

import edu.elp.siselp.entity.Persona;

import java.util.List;

public interface IPersonaService {

    //Listar personas
    List<Persona> listaPersonas();

    //Buscar persona por su dni
    Persona obtenerPersonaByDni(String dni);

}
