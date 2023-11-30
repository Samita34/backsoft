package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.RecetaGuardada;

public interface RecetaGuardadaRepository extends JpaRepository<RecetaGuardada, Integer> {
    // Métodos adicionales si son necesarios
}
