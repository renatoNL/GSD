package start.Model;



import java.time.YearMonth;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_gerenciadoraMensal")
public class GerenciadoraMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private YearMonth masAno;
    private Double rendaTotal;
    private Double despesasFixas;
    private Double despesasVariaveis;
    private Double saldoFinal;

    public GerenciadoraMensal() {
    }

    public GerenciadoraMensal(Long id, YearMonth masAno, Double rendaTotal, Double despesasFixas,
            Double despesasVariaveis, Double saldoFinal) {
        this.id = id;
        this.masAno = masAno;
        this.rendaTotal = rendaTotal;
        this.despesasFixas = despesasFixas;
        this.despesasVariaveis = despesasVariaveis;
        this.saldoFinal = saldoFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YearMonth getMasAno() {
        return masAno;
    }

    public void setMasAno(YearMonth masAno) {
        this.masAno = masAno;
    }

    public Double getRendaTotal() {
        return rendaTotal;
    }

    public void setRendaTotal(Double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public Double getDespesasFixas() {
        return despesasFixas;
    }

    public void setDespesasFixas(Double despesasFixas) {
        this.despesasFixas = despesasFixas;
    }

    public Double getDespesasVariaveis() {
        return despesasVariaveis;
    }

    public void setDespesasVariaveis(Double despesasVariaveis) {
        this.despesasVariaveis = despesasVariaveis;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public void calcularSaldoFinal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSaldoFinal'");
    }

    public GerenciadoraMensal save(GerenciadoraMensal gerenciadora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Optional<GerenciadoraMensal> findByMesAno(YearMonth mesAno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByMesAno'");
    }

    public boolean existsById(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    public void deleteById(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    public GerenciadoraMensal criarGerenciadoraMensal(GerenciadoraMensal gerenciadora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarGerenciadoraMensal'");
    }

    public Optional<GerenciadoraMensal> buscarPorMesAno(YearMonth yearMonth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorMesAno'");
    }

    public GerenciadoraMensal atualizarGerenciadoraMensal(Long id2, GerenciadoraMensal gerenciadoraAtualizada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarGerenciadoraMensal'");
    }

    public boolean deletarGerenciadoraMensal(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarGerenciadoraMensal'");
    }


    
}
