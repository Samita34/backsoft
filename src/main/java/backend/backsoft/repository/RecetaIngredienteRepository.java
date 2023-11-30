package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.RecetaIngrediente;

public interface RecetaIngredienteRepository extends JpaRepository<RecetaIngrediente, Integer> {
    // Métodos adicionales si son necesarios
}
