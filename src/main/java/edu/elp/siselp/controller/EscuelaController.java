package edu.elp.siselp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elp.siselp.entity.Escuela;
import edu.elp.siselp.entity.Estudiante;
import edu.elp.siselp.service.IEscuelaService;
import edu.elp.siselp.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("escuela")
public class EscuelaController {

    @Autowired
    private IEscuelaService escuelaService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/lista")
    public RestResponse listaEscuelas(){
        List<Escuela> escuelaList =  this.escuelaService.listaEscuelas();
        try{
            if (escuelaList.isEmpty()){
                return new RestResponse(HttpStatus.NO_CONTENT.value(),"No se encontraron registros");
            }else {
                return new RestResponse(HttpStatus.OK.value(),"Registro de escuelas ubicadas",escuelaList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Estamos trabajando en ello, vuelva mas tarde");
        }
    }

    @PostMapping("/registrar")
    public RestResponse registrarEscuela(@RequestBody String jsonEscuela) throws JsonProcessingException {

        Escuela escuela = this.objectMapper.readValue(jsonEscuela,Escuela.class);

        try{
            this.escuelaService.registrarEscuela(escuela);
            return new RestResponse(HttpStatus.OK.value(),"Registro guardado satisfactoriamente",escuela);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Lamentamos el inconveniente, vuelva mas tarde");
        }
    }
}
