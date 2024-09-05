package start.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import java.util.Date;

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
    private Date dataVencimento;
    private Boolean quitada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    

    public Quitacao(Long id, String descricao, Double valorTotal, Double valorPago, Double taxaJuros,
            Date dataVencimento, Boolean quitada, UsuarioModel usuario) {
        this.id = id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.taxaJuros = taxaJuros;
        this.dataVencimento = dataVencimento;
        this.quitada = quitada;
        this.usuario = usuario;
    }

    public Quitacao() {
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

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date date) {
        this.dataVencimento = date;
    }

    public Boolean getQuitada() {
        return quitada;
    }

    public void setQuitada(Boolean quitada) {
        this.quitada = quitada;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
