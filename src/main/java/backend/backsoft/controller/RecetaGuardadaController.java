package backend.backsoft.controller;

import backend.backsoft.entity.RecetaGuardada;
import backend.backsoft.service.RecetaGuardadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recetas-guardadas")
public class RecetaGuardadaController {

    private final RecetaGuardadaService recetaGuardadaService;

    @Autowired
    public RecetaGuardadaController(RecetaGuardadaService recetaGuardadaService) {
        this.recetaGuardadaService = recetaGuardadaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<RecetaGuardada> crearRecetaGuardada(@RequestBody RecetaGuardada recetaGuardada) {
        RecetaGuardada nuevaRecetaGuardada = recetaGuardadaService.guardarRecetaGuardada(recetaGuardada);
        return new ResponseEntity<>(nuevaRecetaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaGuardada> obtenerRecetaGuardadaPorId(@PathVariable Integer id) {
        Optional<RecetaGuardada> recetaGuardada = recetaGuardadaService.obtenerRecetaGuardadaPorId(id);
        return recetaGuardada.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecetaGuardada>> listarRecetasGuardadas() {
        List<RecetaGuardada> recetasGuardadas = recetaGuardadaService.listarRecetasGuardadas();
        return new ResponseEntity<>(recetasGuardadas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaGuardada> actualizarRecetaGuardada(@PathVariable Integer id, @RequestBody RecetaGuardada recetaGuardada) {
        RecetaGuardada recetaGuardadaActualizada = recetaGuardadaService.actualizarRecetaGuardada(recetaGuardada, id);
        return new ResponseEntity<>(recetaGuardadaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecetaGuardada(@PathVariable Integer id) {
        recetaGuardadaService.eliminarRecetaGuardada(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
