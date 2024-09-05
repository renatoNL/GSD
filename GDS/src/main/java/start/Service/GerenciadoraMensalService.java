package start.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.Model.GerenciadoraMensal;
import start.Repository.GerenciadoraMensalRepository;

@Service
public class GerenciadoraMensalService {

    @Autowired
    private GerenciadoraMensalRepository gerenciadoraMensalRepository;

    /* public List<GerenciadoraMensal> buscarPorMes(int month) {
            return gerenciadoraMensalRepository.findByMasAnoMonth(month);
        }
    
        public List<GerenciadoraMensal> buscarPorAno(int year) {
            return gerenciadoraMensalRepository.findByMasAnoYear(year);
        }
     */
    public List<GerenciadoraMensal> buscarPorMesEAno(YearMonth masAno) {
        return gerenciadoraMensalRepository.findByMasAno(masAno);
    }

    // Método para criar um novo registro de GerenciadoraMensal
    public GerenciadoraMensal criarGerenciadoraMensal(GerenciadoraMensal gerenciadoraMensal) {
        return gerenciadoraMensalRepository.save(gerenciadoraMensal);
    }

    // Método para atualizar um registro existente de GerenciadoraMensal
    public GerenciadoraMensal atualizarGerenciadoraMensal(Long id, GerenciadoraMensal gerenciadoraMensalAtualizada) {
        Optional<GerenciadoraMensal> gerenciadoraMensalExistente = gerenciadoraMensalRepository.findById(id);
        if (gerenciadoraMensalExistente.isPresent()) {
            GerenciadoraMensal gerenciadoraMensal = gerenciadoraMensalExistente.get();
            gerenciadoraMensal.setMasAno(gerenciadoraMensalAtualizada.getMasAno());
            gerenciadoraMensal.setRendaTotal(gerenciadoraMensalAtualizada.getRendaTotal());
            gerenciadoraMensal.setDespesasFixas(gerenciadoraMensalAtualizada.getDespesasFixas());
            gerenciadoraMensal.setDespesasVariaveis(gerenciadoraMensalAtualizada.getDespesasVariaveis());
            gerenciadoraMensal.setSaldoFinal(gerenciadoraMensalAtualizada.getSaldoFinal());
            return gerenciadoraMensalRepository.save(gerenciadoraMensal);
        } else {
            throw new RuntimeException("Registro não encontrado.");
        }
    }

    // Método para deletar um registro de GerenciadoraMensal
    public void deletarGerenciadoraMensal(Long id) {
        gerenciadoraMensalRepository.deleteById(id);
    }

    // Método para calcular o progresso em relação ao saldo final e às metas
    public double calcularProgresso(Long id) {
        Optional<GerenciadoraMensal> gerenciadoraMensalOpt = gerenciadoraMensalRepository.findById(id);
        if (gerenciadoraMensalOpt.isPresent()) {
            GerenciadoraMensal gerenciadoraMensal = gerenciadoraMensalOpt.get();
            double saldoFinal = gerenciadoraMensal.getSaldoFinal();
            double rendaTotal = gerenciadoraMensal.getRendaTotal();
            return (saldoFinal / rendaTotal) * 100;
        } else {
            throw new RuntimeException("Registro não encontrado.");
        }
    }
}
