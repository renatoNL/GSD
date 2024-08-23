package start.Model;



import java.time.YearMonth;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    public GerenciadoraMensal(Long id, YearMonth masAno, Double rendaTotal, Double despesasFixas,
            Double despesasVariaveis, Double saldoFinal, UsuarioModel usuario) {
        this.id = id;
        this.masAno = masAno;
        this.rendaTotal = rendaTotal;
        this.despesasFixas = despesasFixas;
        this.despesasVariaveis = despesasVariaveis;
        this.saldoFinal = saldoFinal;
        this.usuario = usuario;
    }

    public GerenciadoraMensal() {
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

}
