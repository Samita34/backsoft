package backend.backsoft.controller;

import backend.backsoft.entity.Usuario;
import backend.backsoft.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class.getName());

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        LOGGER.log(Level.INFO, "Inicio del método registrando usuario");
        try {
            Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>("El usuario se ha registrado exitosamente con ID: " + nuevoUsuario.getUserID(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al registrar usuario", e);
            return new ResponseEntity<>("Error al registrar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método registrando usuario");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los usuarios");
        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los usuarios", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los usuarios");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo usuario por ID");
        try {
            Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
            if (usuario.isPresent()) {
                return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener usuario por ID", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo usuario por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        LOGGER.log(Level.INFO, "Inicio del método actualizando usuario");
        try {
            Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario, id);
            if (usuarioActualizado != null) {
                return new ResponseEntity<>("El usuario se ha actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El usuario no se ha actualizado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar usuario", e);
            return new ResponseEntity<>("Error al actualizar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando usuario");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando usuario");
        try {
            usuarioService.eliminarUsuario(id);
            return new ResponseEntity<>("El usuario se ha eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar usuario", e);
            return new ResponseEntity<>("Error al eliminar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando usuario");
        }
    }
}
