package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.Calificacion;
import backend.backsoft.repository.CalificacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public Optional<Calificacion> obtenerCalificacionPorId(Integer id) {
        return calificacionRepository.findById(id);
    }

    public List<Calificacion> listarCalificaciones() {
        return calificacionRepository.findAll();
    }

    public Calificacion actualizarCalificacion(Calificacion calificacion, Integer id) {
        return calificacionRepository.findById(id)
                .map(calificacionExistente -> {
                    calificacionExistente.setPuntuacion(calificacion.getPuntuacion());
                    calificacionExistente.setRecetaID(calificacion.getRecetaID());
                    calificacionExistente.setUserID(calificacion.getUserID());
                    calificacionExistente.setFechaHora(calificacion.getFechaHora());
                    // Aquí puedes agregar más campos para actualizar
                    return calificacionRepository.save(calificacionExistente);
                })
                .orElseGet(() -> {
                    calificacion.setCalificacionID(id);
                    return calificacionRepository.save(calificacion);
                });
    }

    public void eliminarCalificacion(Integer id) {
        calificacionRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
