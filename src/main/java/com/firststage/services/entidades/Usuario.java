package com.firststage.services.entidades;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_USUARIO")
    private Long codigo;
    private String nombres;
    private String apellidos;
    private String pais;
    private String email;
    private String usuario;
    private String password;
    private String generoVideojuego;
    private String medioComunicacion;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGeneroVideojuego() {
        return generoVideojuego;
    }

    public void setGeneroVideojuego(String generoVideojuego) {
        this.generoVideojuego = generoVideojuego;
    }

    public String getMedioComunicacion() {
        return medioComunicacion;
    }

    public void setMedioComunicacion(String medioComunicacion) {
        this.medioComunicacion = medioComunicacion;
    }
}
