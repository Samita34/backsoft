package backend.backsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backsoft.entity.ListaDeComprasIngrediente;

public interface ListaDeComprasIngredienteRepository extends JpaRepository<ListaDeComprasIngrediente, Integer> {
    // Métodos adicionales si son necesarios
}
