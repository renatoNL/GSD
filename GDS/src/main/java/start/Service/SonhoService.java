package start.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import start.Model.Sonho;
import start.Repository.SonhoRepository;

@Service
public class SonhoService {

    @Autowired
    private SonhoRepository sonhoRepository;

    public List<Sonho> findAll() {
        return sonhoRepository.findAll();
    }

    public Sonho findById(Long id) {
        Optional<Sonho> sonho = sonhoRepository.findById(id);
        return sonho.orElse(null);
    }

    public Sonho createSonho(Sonho sonho) {
        return sonhoRepository.save(sonho);
    }

    public Sonho updateSonho(Long id, Sonho sonhoAtualizado) {
        Optional<Sonho> sonhoOptional = sonhoRepository.findById(id);
        if (sonhoOptional.isPresent()) {
            Sonho sonhoExistente = sonhoOptional.get();
            sonhoExistente.setDescricao(sonhoAtualizado.getDescricao());
            sonhoExistente.setValor(sonhoAtualizado.getValor());
            sonhoExistente.setPrazo(sonhoAtualizado.getPrazo());
            return sonhoRepository.save(sonhoExistente);
        }
        
        return null;
    }

    public boolean deleteSonho(Long id) {
        if (sonhoRepository.existsById(id)) {
            sonhoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
