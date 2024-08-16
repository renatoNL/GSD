package start.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_quitacao")
public class Quitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String descricao;
    private Double valorTotal;
    private Double valorPago;
    private Double taxaJuros;
    private LocalDate dataVencimento;
    private Boolean quitada;

    public Quitacao() {}

    public Quitacao(Long id, String descricao, Double valorTotal, Double valorPago, Double taxaJuros, LocalDate dataVencimento, Boolean quitada) {
        this.id = id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.taxaJuros = taxaJuros;
        this.dataVencimento = dataVencimento;
        this.quitada = quitada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getQuitada() {
        return quitada;
    }

    public void setQuitada(Boolean quitada) {
        this.quitada = quitada;
    }

    public Double calcularValorAtualizado() {
        int meses = calcularMesesAtraso();
        return valorTotal * Math.pow(1 + taxaJuros, meses);
    }
    private int calcularMesesAtraso() {
        if (LocalDate.now().isAfter(dataVencimento)) {
            return LocalDate.now().getMonthValue() - dataVencimento.getMonthValue();
        }
        return 0;
    }

}
