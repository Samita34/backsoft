package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Métodos adicionales si son necesarios
}
