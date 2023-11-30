package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.ListaDeComprasIngrediente;
import backend.backsoft.repository.ListaDeComprasIngredienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDeComprasIngredienteService {

    private final ListaDeComprasIngredienteRepository listaDeComprasIngredientesRepository;

    @Autowired
    public ListaDeComprasIngredienteService(ListaDeComprasIngredienteRepository listaDeComprasIngredientesRepository) {
        this.listaDeComprasIngredientesRepository = listaDeComprasIngredientesRepository;
    }

    public ListaDeComprasIngrediente guardarListaDeComprasIngrediente(ListaDeComprasIngrediente listaDeComprasIngrediente) {
        return listaDeComprasIngredientesRepository.save(listaDeComprasIngrediente);
    }

    public Optional<ListaDeComprasIngrediente> obtenerListaDeComprasIngredientePorId(Integer id) {
        return listaDeComprasIngredientesRepository.findById(id);
    }

    public List<ListaDeComprasIngrediente> listarListasDeComprasIngredientes() {
        return listaDeComprasIngredientesRepository.findAll();
    }

    public ListaDeComprasIngrediente actualizarListaDeComprasIngrediente(ListaDeComprasIngrediente listaDeComprasIngrediente, Integer id) {
        return listaDeComprasIngredientesRepository.findById(id)
                .map(listaExistente -> {
                    // Actualiza los campos necesarios
                    return listaDeComprasIngredientesRepository.save(listaExistente);
                })
                .orElseGet(() -> {
                    listaDeComprasIngrediente.setLisComprasIngredientesID(id);
                    return listaDeComprasIngredientesRepository.save(listaDeComprasIngrediente);
                });
    }

    public void eliminarListaDeComprasIngrediente(Integer id) {
        listaDeComprasIngredientesRepository.deleteById(id);
    }
}
