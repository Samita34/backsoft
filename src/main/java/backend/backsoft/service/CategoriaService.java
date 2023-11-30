package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.Categoria;
import backend.backsoft.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria actualizarCategoria(Categoria categoria, Integer id) {
        return categoriaRepository.findById(id)
                .map(categoriaExistente -> {
                    categoriaExistente.setNombreCategoria(categoria.getNombreCategoria());
                    // Aquí puedes agregar más campos para actualizar
                    return categoriaRepository.save(categoriaExistente);
                })
                .orElseGet(() -> {
                    categoria.setCategoriaID(id);
                    return categoriaRepository.save(categoria);
                });
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
