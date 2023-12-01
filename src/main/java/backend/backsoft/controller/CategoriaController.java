package backend.backsoft.controller;

import backend.backsoft.entity.Categoria;
import backend.backsoft.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private static final Logger LOGGER = Logger.getLogger(CategoriaController.class.getName());

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCategoria(@RequestBody Categoria categoria) {
        LOGGER.log(Level.INFO, "Inicio del método creando categoría");
        try {
            Categoria nuevaCategoria = categoriaService.guardarCategoria(categoria);
            return new ResponseEntity<>("La categoría se ha creado exitosamente con ID: " + nuevaCategoria.getCategoriaID(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear categoría", e);
            return new ResponseEntity<>("Error al crear categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando categoría");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todas las categorías");
        try {
            List<Categoria> categorias = categoriaService.listarCategorias();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todas las categorías", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todas las categorías");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo categoría por ID");
        try {
            Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
            if (categoria.isPresent()) {
                return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener categoría por ID", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo categoría por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        LOGGER.log(Level.INFO, "Inicio del método actualizando categoría");
        try {
            Categoria categoriaActualizada = categoriaService.actualizarCategoria(categoria, id);
            if (categoriaActualizada != null) {
                return new ResponseEntity<>("La categoría se ha actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("La categoría no se ha actualizado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar categoría", e);
            return new ResponseEntity<>("Error al actualizar categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando categoría");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando categoría");
        try {
            categoriaService.eliminarCategoria(id);
            return new ResponseEntity<>("La categoría se ha eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar categoría", e);
            return new ResponseEntity<>("Error al eliminar categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando categoría");
        }
    }
}
