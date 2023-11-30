package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.Ingrediente;
import backend.backsoft.repository.IngredienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public Optional<Ingrediente> obtenerIngredientePorId(Integer id) {
        return ingredienteRepository.findById(id);
    }

    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente actualizarIngrediente(Ingrediente ingrediente, Integer id) {
        return ingredienteRepository.findById(id)
                .map(ingredienteExistente -> {
                    ingredienteExistente.setNombre(ingrediente.getNombre());
                    ingredienteExistente.setTipo(ingrediente.getTipo());
                    ingredienteExistente.setCantidad(ingrediente.getCantidad());
                    // Aquí puedes agregar más campos para actualizar
                    return ingredienteRepository.save(ingredienteExistente);
                })
                .orElseGet(() -> {
                    ingrediente.setIngredienteID(id);
                    return ingredienteRepository.save(ingrediente);
                });
    }

    public void eliminarIngrediente(Integer id) {
        ingredienteRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
