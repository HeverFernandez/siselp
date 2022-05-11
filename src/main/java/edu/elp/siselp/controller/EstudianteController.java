package edu.elp.siselp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import edu.elp.siselp.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/list")
    public List<Estudiante> listaEstudiantesByEscuela(@RequestParam("idescuela")Escuela idescuela){
        return this.estudianteService.listaEstudiantesByEscuela(idescuela);
    }

    @GetMapping("/listPorPagina")
    public Page<Estudiante> listaEstudiantesPorPagina(@RequestParam("pagina") int pagina, @RequestParam("idescuela")Escuela idescuela){
        Pageable pageable = PageRequest.of(pagina,3);
        return this.estudianteService.listaEstudiantesPorPagina(pageable,idescuela);
    }

    @PostMapping("/registrar")
    public String registrarEstudiante(@RequestBody String jsonEstudiante) throws JsonProcessingException {

        Estudiante estudiante = this.objectMapper.readValue(jsonEstudiante,Estudiante.class);

        this.estudianteService.guardarEstudiante(estudiante);

        return "Se guardó correctamente";
    }

    @GetMapping("/bycodigo/{coddni}")
    public Estudiante estudianteByDni(@PathVariable("coddni") String coddni){
        return this.estudianteService.obtenerPorCodigoOrDni(coddni);
    }
}
