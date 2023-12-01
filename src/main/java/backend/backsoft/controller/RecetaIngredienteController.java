package backend.backsoft.controller;

import backend.backsoft.entity.RecetaIngrediente;
import backend.backsoft.service.RecetaIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recetas-ingredientes")
public class RecetaIngredienteController {

    private final RecetaIngredienteService recetaIngredienteService;

    @Autowired
    public RecetaIngredienteController(RecetaIngredienteService recetaIngredienteService) {
        this.recetaIngredienteService = recetaIngredienteService;
    }

    @PostMapping("/crear")
    public RecetaIngrediente crearRecetaIngrediente(@RequestBody RecetaIngrediente recetaIngrediente) {
        return recetaIngredienteService.guardarRecetaIngrediente(recetaIngrediente);
    }

    @GetMapping("/{id}")
    public Optional<RecetaIngrediente> obtenerRecetaIngredientePorId(@PathVariable Integer id) {
        return recetaIngredienteService.obtenerRecetaIngredientePorId(id);
    }

    @GetMapping("/listar")
    public List<RecetaIngrediente> listarRecetasIngredientes() {
        return recetaIngredienteService.listarRecetasIngredientes();
    }

    @PutMapping("/{id}")
    public RecetaIngrediente actualizarRecetaIngrediente(@RequestBody RecetaIngrediente recetaIngrediente, @PathVariable Integer id) {
        return recetaIngredienteService.actualizarRecetaIngrediente(recetaIngrediente, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRecetaIngrediente(@PathVariable Integer id) {
        recetaIngredienteService.eliminarRecetaIngrediente(id);
    }
}
