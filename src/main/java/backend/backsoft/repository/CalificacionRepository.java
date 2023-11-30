package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    // Métodos adicionales si son necesarios
}
