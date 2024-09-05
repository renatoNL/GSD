package start.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.Model.Quitacao;
import start.Repository.QuitacaoRepository;

@Service
public class QuitacaoService {

    @Autowired
    private QuitacaoRepository quitacaoRepository;

    public List<Quitacao> findAll() {
        return quitacaoRepository.findAll();
    }

    public Quitacao findById(Long id) {
        Optional<Quitacao> divida = quitacaoRepository.findById(id);
        return divida.orElse(null);
    }

    public Quitacao createDivida(Quitacao quitacao) {
        quitacao.setQuitada(false);
        return quitacaoRepository.save(quitacao);
    }

    public Quitacao updateDivida(Long id, Quitacao dividaAtualizada) {
        Optional<Quitacao> dividaOptional = quitacaoRepository.findById(id);
        if (dividaOptional.isPresent()) {
            Quitacao dividaExistente = dividaOptional.get();
            dividaExistente.setDescricao(dividaAtualizada.getDescricao());
            dividaExistente.setValorTotal(dividaAtualizada.getValorTotal());
            dividaExistente.setValorPago(dividaAtualizada.getValorPago());
            dividaExistente.setTaxaJuros(dividaAtualizada.getTaxaJuros());
            dividaExistente.setDataVencimento(dividaAtualizada.getDataVencimento());
            dividaExistente.setQuitada(dividaAtualizada.getQuitada());
            return quitacaoRepository.save(dividaExistente);
        }
        return null;
    }

    public boolean deleteDivida(Long id) {
        if (quitacaoRepository.existsById(id)) {
            quitacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Quitacao quitarDivida(Long id, Double valorPago) {
        Optional<Quitacao> dividaOptional = quitacaoRepository.findById(id);
        if (dividaOptional.isPresent()) {
            Quitacao dividaExistente = dividaOptional.get();
            Double valorAtualizado = calcularValorAtualizado(dividaExistente);
            dividaExistente.setValorPago(dividaExistente.getValorPago() + valorPago);
    
            if (dividaExistente.getValorPago() >= valorAtualizado) {
                dividaExistente.setQuitada(true);
            }
            return quitacaoRepository.save(dividaExistente);
        }
        return null;
    }

    public Double calcularValorAtualizado(Quitacao divida) {
        Double valorTotal = divida.getValorTotal();
        Double taxaJuros = divida.getTaxaJuros();
        Double valorPago = divida.getValorPago();
        Integer diasVencidos = calcularDiasVencidos(divida.getDataVencimento());
    
        Double valorAtualizado = valorTotal + (valorTotal * taxaJuros * diasVencidos / 365);
    
        return valorAtualizado;
    }

    public Integer calcularDiasVencidos(Date dataVencimento) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dataVencimento);
    Integer diasVencidos = calendar.get(Calendar.DAY_OF_YEAR) - Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

    return diasVencidos;
}
}
