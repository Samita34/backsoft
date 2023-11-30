package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Métodos adicionales si son necesarios
}
