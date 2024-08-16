package start.Service;

import start.Model.GerenciadoraMensal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Optional;

@Service
public class GerenciadoraMensalService {

    @Autowired
    private GerenciadoraMensal gerenciadoraMensalRepository;

    public GerenciadoraMensal criarGerenciadoraMensal(GerenciadoraMensal gerenciadora) {
        gerenciadora.calcularSaldoFinal();
        return gerenciadoraMensalRepository.save(gerenciadora);
    }

    public Optional<GerenciadoraMensal> buscarPorMesAno(YearMonth yearMonth) {
        return gerenciadoraMensalRepository.findByMesAno(yearMonth);
    }

    public GerenciadoraMensal atualizarGerenciadoraMensal(YearMonth id, GerenciadoraMensal atualizacao) {
        Optional<GerenciadoraMensal> gerenciadoraExistente = gerenciadoraMensalRepository.findByMesAno(id);
        if (gerenciadoraExistente.isPresent()) {
            GerenciadoraMensal gerenciadora = gerenciadoraExistente.get();
            gerenciadora.setRendaTotal(atualizacao.getRendaTotal());
            gerenciadora.setDespesasFixas(atualizacao.getDespesasFixas());
            gerenciadora.setDespesasVariaveis(atualizacao.getDespesasVariaveis());
            gerenciadora.calcularSaldoFinal();
            return gerenciadoraMensalRepository.save(gerenciadora);
        }
        return null;
    }

    public boolean deletarGerenciadoraMensal(Long id) {
        if (gerenciadoraMensalRepository.existsById(id)) {
            gerenciadoraMensalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}