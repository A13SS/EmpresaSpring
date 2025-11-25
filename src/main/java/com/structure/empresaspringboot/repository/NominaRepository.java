package com.structure.empresaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.structure.empresaspringboot.model.Nomina;

import java.util.Optional;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {
    @Query("SELECT n FROM Nomina n WHERE n.empleado.dni = :dni")
    Optional<Nomina> findByEmpleadoDni(@Param("dni") String dni);
}
