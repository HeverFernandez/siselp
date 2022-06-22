package edu.elp.siselp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import edu.elp.siselp.service.IEstudianteService;
import edu.elp.siselp.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/list")
    public RestResponse listaEstudiantesByEscuela(@RequestParam("idescuela")Escuela idescuela){
        List<Estudiante> estudianteList = this.estudianteService.listaEstudiantesByEscuela(idescuela);
        try{
            if (estudianteList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de estudiantes",estudianteList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Estamos trabajando en ello, vuelva mas tarde");
        }
    }

    @GetMapping("/listPorPagina")
    public Page<Estudiante> listaEstudiantesPorPagina(@RequestParam("pagina") int pagina, @RequestParam("idescuela")Escuela idescuela){
        Pageable pageable = PageRequest.of(pagina,3);
        return this.estudianteService.listaEstudiantesPorPagina(pageable,idescuela);
    }

    @PostMapping("/registrar")
    public RestResponse registrarEstudiante(@RequestBody String jsonEstudiante) throws JsonProcessingException {

        Estudiante estudiante = this.objectMapper.readValue(jsonEstudiante,Estudiante.class);

        try{
            this.estudianteService.guardarEstudiante(estudiante);
            return new RestResponse(HttpStatus.OK.value(),"Registro guardado satisfactoriamente",estudiante);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }

    @GetMapping("/bycodigo/{coddni}")
    public Estudiante estudianteByDni(@PathVariable("coddni") String coddni){
        return this.estudianteService.obtenerPorCodigoOrDni(coddni);
    }

    @PostMapping("/delete/{idestudiante}")
    public String eliminarEstudiante(@PathVariable("idestudiante") Long idestudiante){
        this.estudianteService.eliminarEstudiante(idestudiante);
        return "Estudiante eliminado correctamente";
    }

    @PutMapping("/update")
    public String actualizarEstudiante(@RequestBody String JsonEstudiante) throws JsonProcessingException {
        Estudiante estudiante = this.objectMapper.readValue(JsonEstudiante,Estudiante.class);

        this.estudianteService.guardarEstudiante(estudiante);

        return "Estudiante actualizado correctamente";
    }
}
