package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    // Métodos adicionales si son necesarios
}
