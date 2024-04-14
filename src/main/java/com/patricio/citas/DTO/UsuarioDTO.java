package com.patricio.citas.DTO;

import java.util.Objects;

public abstract class UsuarioDTO {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String clave, String usuario, String apellidos, String nombre) {
        this.clave = clave;
        this.usuario = usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(usuario, that.usuario) && Objects.equals(clave, that.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, usuario, clave);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}