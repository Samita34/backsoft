package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    // Métodos adicionales si son necesarios
}
