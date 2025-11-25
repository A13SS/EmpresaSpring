package com.structure.empresaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.structure.empresaspringboot.model.Empleado;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByDni(String dni);
    List<Empleado> findByNombreContainingIgnoreCase(String nombre);
    List<Empleado> findBySexo(Character sexo);
    List<Empleado> findByCategoria(Integer categoria);
    List<Empleado> findByAnyos(Integer anyos);
}
