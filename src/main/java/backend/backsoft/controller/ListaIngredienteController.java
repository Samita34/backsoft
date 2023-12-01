package backend.backsoft.controller;

import backend.backsoft.entity.ListaDeComprasIngrediente;
import backend.backsoft.service.ListaDeComprasIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lista-ingredientes")
public class ListaIngredienteController {

    private final ListaDeComprasIngredienteService listaDeComprasIngredienteService;

    @Autowired
    public ListaIngredienteController(ListaDeComprasIngredienteService listaDeComprasIngredienteService) {
        this.listaDeComprasIngredienteService = listaDeComprasIngredienteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ListaDeComprasIngrediente> crearListaIngrediente(@RequestBody ListaDeComprasIngrediente listaDeComprasIngrediente) {
        ListaDeComprasIngrediente nuevaListaIngrediente = listaDeComprasIngredienteService.guardarListaDeComprasIngrediente(listaDeComprasIngrediente);
        return new ResponseEntity<>(nuevaListaIngrediente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeComprasIngrediente> obtenerListaIngredientePorId(@PathVariable Integer id) {
        Optional<ListaDeComprasIngrediente> listaIngrediente = listaDeComprasIngredienteService.obtenerListaDeComprasIngredientePorId(id);
        return listaIngrediente.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListaDeComprasIngrediente>> listarListasIngredientes() {
        List<ListaDeComprasIngrediente> listaIngredientes = listaDeComprasIngredienteService.listarListasDeComprasIngredientes();
        return new ResponseEntity<>(listaIngredientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeComprasIngrediente> actualizarListaIngrediente(@PathVariable Integer id, @RequestBody ListaDeComprasIngrediente listaDeComprasIngrediente) {
        ListaDeComprasIngrediente listaIngredienteActualizada = listaDeComprasIngredienteService.actualizarListaDeComprasIngrediente(listaDeComprasIngrediente, id);
        return new ResponseEntity<>(listaIngredienteActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarListaIngrediente(@PathVariable Integer id) {
        listaDeComprasIngredienteService.eliminarListaDeComprasIngrediente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
