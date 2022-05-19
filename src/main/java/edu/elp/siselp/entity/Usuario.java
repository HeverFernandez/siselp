package edu.elp.siselp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idusuario;

    private String username;
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idpersona")
    private Persona persona;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idrole"))
    private Set<Rol> roles = new HashSet<>();


    public Usuario() {
    }

    public Usuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String username, String contrasenia, Persona persona, Set<Rol> roles) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
        this.roles = roles;
    }

    public Usuario(Long idusuario, String username, String contrasenia, Persona persona) {
        this.idusuario = idusuario;
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }

    public Usuario(Long idusuario, String username, String contrasenia, Persona persona, Set<Rol> roles) {
        this.idusuario = idusuario;
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
        this.roles = roles;
    }

    public Usuario(String username, String contrasenia, Persona persona) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
