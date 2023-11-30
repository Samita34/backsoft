package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.ListaDeCompras;

public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Integer> {
    // Métodos adicionales si son necesarios
}
