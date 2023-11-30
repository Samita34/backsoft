package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.RecetaGuardada;
import backend.backsoft.repository.RecetaGuardadaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaGuardadaService {

    private final RecetaGuardadaRepository recetaGuardadaRepository;

    @Autowired
    public RecetaGuardadaService(RecetaGuardadaRepository recetaGuardadaRepository) {
        this.recetaGuardadaRepository = recetaGuardadaRepository;
    }

    public RecetaGuardada guardarRecetaGuardada(RecetaGuardada recetaGuardada) {
        return recetaGuardadaRepository.save(recetaGuardada);
    }

    public Optional<RecetaGuardada> obtenerRecetaGuardadaPorId(Integer id) {
        return recetaGuardadaRepository.findById(id);
    }

    public List<RecetaGuardada> listarRecetasGuardadas() {
        return recetaGuardadaRepository.findAll();
    }

    public RecetaGuardada actualizarRecetaGuardada(RecetaGuardada recetaGuardada, Integer id) {
        return recetaGuardadaRepository.findById(id)
                .map(recetaExistente -> {
                    // Actualiza los campos necesarios
                    return recetaGuardadaRepository.save(recetaExistente);
                })
                .orElseGet(() -> {
                    recetaGuardada.setRecetasGuardadasID(id);
                    return recetaGuardadaRepository.save(recetaGuardada);
                });
    }

    public void eliminarRecetaGuardada(Integer id) {
        recetaGuardadaRepository.deleteById(id);
    }
}
