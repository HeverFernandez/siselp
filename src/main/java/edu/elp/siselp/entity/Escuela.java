package edu.elp.siselp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="escuela")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idescuela;

    private String codigo;

    private String denominacion;

    @OneToMany(mappedBy = "escuela")
    private List<Estudiante> estudianteLis;
    
    public Escuela() {
    }

    public Escuela(Long idescuela) {
        this.idescuela = idescuela;
    }

    public Escuela(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public Long getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(Long idescuela) {
        this.idescuela = idescuela;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Estudiante> getEstudianteLis() {
        return estudianteLis;
    }

    public void setEstudianteLis(List<Estudiante> estudianteLis) {
        this.estudianteLis = estudianteLis;
    }


}
