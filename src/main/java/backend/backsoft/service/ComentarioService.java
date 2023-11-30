package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.Comentario;
import backend.backsoft.repository.ComentarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario guardarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> obtenerComentarioPorId(Integer id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario actualizarComentario(Comentario comentario, Integer id) {
        return comentarioRepository.findById(id)
                .map(comentarioExistente -> {
                    comentarioExistente.setTextoComentario(comentario.getTextoComentario());
                    comentarioExistente.setFechaHora(comentario.getFechaHora());
                    comentarioExistente.setUserID(comentario.getUserID());
                    comentarioExistente.setRecetaID(comentario.getRecetaID());
                    // Aquí puedes agregar más campos para actualizar
                    return comentarioRepository.save(comentarioExistente);
                })
                .orElseGet(() -> {
                    comentario.setComentarioID(id);
                    return comentarioRepository.save(comentario);
                });
    }

    public void eliminarComentario(Integer id) {
        comentarioRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
