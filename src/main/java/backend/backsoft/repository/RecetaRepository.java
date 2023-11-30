package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    // Métodos adicionales si son necesarios
}
