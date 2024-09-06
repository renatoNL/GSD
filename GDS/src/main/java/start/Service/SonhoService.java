package start.Service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String, Double> simularInvestimento(Sonho sonho) {
        // Implement your logic here to calculate the investment
        double valorTotal = sonho.getValor();
        int meses = calcularMesesEntreDatas(sonho.getPrazo());
        double valorMensal = valorTotal / meses;

        Map<String, Double> resultado = new HashMap<>();
        resultado.put("valorInvestimento", valorMensal);
        return resultado;
    }

    private int calcularMesesEntreDatas(LocalDate prazo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMesesEntreDatas'");
    }

    public boolean deleteSonho(Long id) {
        if (sonhoRepository.existsById(id)) {
            sonhoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Map<String, Double> simularInvestimento(Sonho sonho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
