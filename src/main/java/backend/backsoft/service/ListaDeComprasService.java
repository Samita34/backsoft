package backend.backsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backsoft.entity.ListaDeCompras;
import backend.backsoft.repository.ListaDeComprasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDeComprasService {

    private final ListaDeComprasRepository listaDeComprasRepository;

    @Autowired
    public ListaDeComprasService(ListaDeComprasRepository listaDeComprasRepository) {
        this.listaDeComprasRepository = listaDeComprasRepository;
    }

    public ListaDeCompras guardarListaDeCompras(ListaDeCompras listaDeCompras) {
        return listaDeComprasRepository.save(listaDeCompras);
    }

    public Optional<ListaDeCompras> obtenerListaDeComprasPorId(Integer id) {
        return listaDeComprasRepository.findById(id);
    }

    public List<ListaDeCompras> listarListasDeCompras() {
        return listaDeComprasRepository.findAll();
    }

    public ListaDeCompras actualizarListaDeCompras(ListaDeCompras listaDeCompras, Integer id) {
        return listaDeComprasRepository.findById(id)
                .map(listaExistente -> {
                    listaExistente.setNombreLista(listaDeCompras.getNombreLista());
                    listaExistente.setUsuario(listaDeCompras.getUsuario());
                    // Aquí puedes agregar más campos para actualizar
                    return listaDeComprasRepository.save(listaExistente);
                })
                .orElseGet(() -> {
                    listaDeCompras.setListaID(id);
                    return listaDeComprasRepository.save(listaDeCompras);
                });
    }

    public void eliminarListaDeCompras(Integer id) {
        listaDeComprasRepository.deleteById(id);
    }

    // Otros métodos que puedas necesitar
}
