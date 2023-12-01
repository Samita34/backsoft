package backend.backsoft.controller;

import backend.backsoft.entity.Calificacion;
import backend.backsoft.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/calificacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalificacionController {

    private final CalificacionService calificacionService;

    @Autowired
    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion nuevaCalificacion = calificacionService.guardarCalificacion(calificacion);
        return new ResponseEntity<>(nuevaCalificacion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> obtenerCalificacionPorId(@PathVariable Integer id) {
        Optional<Calificacion> calificacion = calificacionService.obtenerCalificacionPorId(id);
        return calificacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Calificacion>> listarCalificaciones() {
        List<Calificacion> calificaciones = calificacionService.listarCalificaciones();
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Integer id, @RequestBody Calificacion calificacion) {
        Calificacion calificacionActualizada = calificacionService.actualizarCalificacion(calificacion, id);
        return new ResponseEntity<>(calificacionActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarCalificacion(@PathVariable Integer id) {
        calificacionService.eliminarCalificacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
