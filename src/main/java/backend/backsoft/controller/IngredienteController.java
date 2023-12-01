package backend.backsoft.controller;

import backend.backsoft.entity.Ingrediente;
import backend.backsoft.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/ingrediente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<Ingrediente> createIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente newIngrediente = ingredienteService.guardarIngrediente(ingrediente);
        return new ResponseEntity<>(newIngrediente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> findIngredienteById(@PathVariable Integer id) {
        Optional<Ingrediente> ingrediente = ingredienteService.obtenerIngredientePorId(id);
        return ingrediente.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<List<Ingrediente>> getAllIngredientes() {
        List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> updateIngrediente(@PathVariable Integer id, @RequestBody Ingrediente ingrediente) {
        Ingrediente updatedIngrediente = ingredienteService.actualizarIngrediente(ingrediente, id);
        return new ResponseEntity<>(updatedIngrediente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteIngrediente(@PathVariable Integer id) {
        ingredienteService.eliminarIngrediente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
