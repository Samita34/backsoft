package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.RecetaIngrediente;
import backend.backsoft.repository.RecetaIngredienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaIngredienteService {

    private final RecetaIngredienteRepository recetaIngredienteRepository;

    @Autowired
    public RecetaIngredienteService(RecetaIngredienteRepository recetaIngredienteRepository) {
        this.recetaIngredienteRepository = recetaIngredienteRepository;
    }

    public RecetaIngrediente guardarRecetaIngrediente(RecetaIngrediente recetaIngrediente) {
        return recetaIngredienteRepository.save(recetaIngrediente);
    }

    public Optional<RecetaIngrediente> obtenerRecetaIngredientePorId(Integer id) {
        return recetaIngredienteRepository.findById(id);
    }

    public List<RecetaIngrediente> listarRecetasIngredientes() {
        return recetaIngredienteRepository.findAll();
    }

    public RecetaIngrediente actualizarRecetaIngrediente(RecetaIngrediente recetaIngrediente, Integer id) {
        return recetaIngredienteRepository.findById(id)
                .map(ingredienteExistente -> {
                    // Aquí actualizas los campos necesarios
                    return recetaIngredienteRepository.save(ingredienteExistente);
                })
                .orElseGet(() -> {
                    recetaIngrediente.setReceIngreID(id);
                    return recetaIngredienteRepository.save(recetaIngrediente);
                });
    }

    public void eliminarRecetaIngrediente(Integer id) {
        recetaIngredienteRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
