package edu.elp.siselp.payload;

import edu.elp.siselp.entity.Persona;

import javax.validation.constraints.*;

/**
 * Created by HeverFernandez on 02/08/17.
 */

public class SignUpRequest {

    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    private Persona idpersona;

    private Long idrole;

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdrole() {
        return idrole;
    }

    public void setRole(Long idrole) {
        this.idrole = idrole;
    }

    //    public Set<String> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<String> role) {
//        this.role = role;
//    }


    @Override
    public String toString() {
        return "SignUpRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idpersona=" + idpersona +
                ", idrole=" + idrole +
                '}';
    }
}
