package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.Receta;
import backend.backsoft.repository.RecetaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    @Autowired
    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public Receta guardarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    public Optional<Receta> obtenerRecetaPorId(Integer id) {
        return recetaRepository.findById(id);
    }

    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    public Receta actualizarReceta(Receta receta, Integer id) {
        return recetaRepository.findById(id)
                .map(recetaExistente -> {
                    recetaExistente.setNombreReceta(receta.getNombreReceta());
                    recetaExistente.setProcedimiento(receta.getProcedimiento());
                    recetaExistente.setTiempoPreparacion(receta.getTiempoPreparacion());
                    recetaExistente.setPorciones(receta.getPorciones());
                    recetaExistente.setDescripcionCorta(receta.getDescripcionCorta());
                    recetaExistente.setImagenReceta(receta.getImagenReceta());
                    recetaExistente.setCategoriaCategoriaID(receta.getCategoriaCategoriaID());
                    // Aquí puedes agregar más campos para actualizar según tu entidad Receta
                    return recetaRepository.save(recetaExistente);
                })
                .orElseGet(() -> {
                    receta.setRecetaID(id);
                    return recetaRepository.save(receta);
                });
    }

    public void eliminarReceta(Integer id) {
        recetaRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
