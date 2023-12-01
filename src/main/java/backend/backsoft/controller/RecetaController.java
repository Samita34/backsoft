package backend.backsoft.controller;

import backend.backsoft.entity.Receta;
import backend.backsoft.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/receta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecetaController {

    private final RecetaService recetaService;

    @Autowired
    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Receta> createReceta(@RequestBody Receta receta) {
        Receta nuevaReceta = recetaService.guardarReceta(receta);
        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Integer id) {
        Optional<Receta> recetaOptional = recetaService.obtenerRecetaPorId(id);
        return recetaOptional.map(receta -> new ResponseEntity<>(receta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<List<Receta>> getAllRecetas() {
        List<Receta> recetas = recetaService.listarRecetas();
        return new ResponseEntity<>(recetas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> updateReceta(@PathVariable Integer id, @RequestBody Receta receta) {
        Receta recetaActualizada = recetaService.actualizarReceta(receta, id);
        return new ResponseEntity<>(recetaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteReceta(@PathVariable Integer id) {
        recetaService.eliminarReceta(id);
        return new ResponseEntity<>(Map.of("message", "Receta eliminada exitosamente"), HttpStatus.OK);
    }
}
