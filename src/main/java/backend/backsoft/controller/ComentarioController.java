package backend.backsoft.controller;

import backend.backsoft.dto.ComentarioDTO;
import backend.backsoft.entity.Comentario;
import backend.backsoft.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping("/crear")
        public ResponseEntity<?> crearComentario(@RequestBody ComentarioDTO comentarioDTO) {
            // Validar y procesar comentarioDTO si es necesario

            Comentario nuevoComentario = new Comentario();
            nuevoComentario.setRecetaID(comentarioDTO.getRecetaId());
            nuevoComentario.setUserID(comentarioDTO.getUserId());
            nuevoComentario.setTextoComentario(comentarioDTO.getTextoComentario());

            // Asigna la fecha y hora actual antes de guardar el comentario
            nuevoComentario.setFechaHora(LocalDateTime.now());

            // Guardar el comentario en el servicio
            comentarioService.guardarComentario(nuevoComentario);

            // Respuesta de éxito
            return ResponseEntity.ok("Comentario creado con éxito");
        }


    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Integer id) {
        Optional<Comentario> comentario = comentarioService.obtenerComentarioPorId(id);
        return comentario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Comentario>> listarComentarios() {
        List<Comentario> comentarios = comentarioService.listarComentarios();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Integer id, @RequestBody Comentario comentario) {
        Comentario comentarioActualizado = comentarioService.actualizarComentario(comentario, id);
        return new ResponseEntity<>(comentarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarComentario(@PathVariable Integer id) {
        comentarioService.eliminarComentario(id);
        return new ResponseEntity<>(Map.of("message", "Comentario eliminado exitosamente"), HttpStatus.OK);
    }
}
