package backend.backsoft.controller;

import backend.backsoft.entity.ListaDeCompras;
import backend.backsoft.service.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lista-compras")
public class ListaCompraController {

    private final ListaDeComprasService listaDeComprasService;

    @Autowired
    public ListaCompraController(ListaDeComprasService listaDeComprasService) {
        this.listaDeComprasService = listaDeComprasService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ListaDeCompras> crearListaDeCompras(@RequestBody ListaDeCompras listaDeCompras) {
        ListaDeCompras nuevaLista = listaDeComprasService.guardarListaDeCompras(listaDeCompras);
        return new ResponseEntity<>(nuevaLista, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ListaDeCompras>> obtenerListaDeComprasPorId(@PathVariable Integer id) {
        Optional<ListaDeCompras> lista = listaDeComprasService.obtenerListaDeComprasPorId(id);
        if (lista.isPresent()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListaDeCompras>> listarListasDeCompras() {
        List<ListaDeCompras> listas = listaDeComprasService.listarListasDeCompras();
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeCompras> actualizarListaDeCompras(@PathVariable Integer id, @RequestBody ListaDeCompras listaDeCompras) {
        ListaDeCompras listaActualizada = listaDeComprasService.actualizarListaDeCompras(listaDeCompras, id);
        return new ResponseEntity<>(listaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarListaDeCompras(@PathVariable Integer id) {
        listaDeComprasService.eliminarListaDeCompras(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
