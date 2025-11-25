package com.structure.empresaspringboot.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 9, unique = true)
    private String dni;

    @Column(length = 1)
    private Character sexo;

    @Column
    private Integer categoria;

    @Column(name = "anyos")
    private Integer anyos;

    public Empleado() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public Character getSexo() { return sexo; }
    public void setSexo(Character sexo) { this.sexo = sexo; }

    public Integer getCategoria() { return categoria == null ? 1 : categoria; }
    public void setCategoria(Integer categoria) { this.categoria = categoria; }

    public Integer getAnyos() { return anyos == null ? 0 : anyos; }
    public void setAnyos(Integer anyos) { this.anyos = anyos; }
}
