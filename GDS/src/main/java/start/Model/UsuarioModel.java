package start.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String cpf; //add chave unica
private LocalDate dataNascimento;
private String celular;
private String email; //add chave unica // verificar o email
private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sonho> sonhos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quitacao> quitacoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GerenciadoraMensal> gerenciadoraMensal = new ArrayList<>();


public UsuarioModel() {
    }

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

public LocalDate getDataNascimento() {
    return dataNascimento;
}

public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
}

public String getCelular() {
    return celular;
}

public void setCelular(String celular) {
    this.celular = celular;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public List<Sonho> getSonhos() {
    return sonhos;
}

public void setSonhos(List<Sonho> sonhos) {
    this.sonhos = sonhos;
}

public List<Quitacao> getQuitacoes() {
    return quitacoes;
}

public void setQuitacoes(List<Quitacao> quitacoes) {
    this.quitacoes = quitacoes;
}

public List<GerenciadoraMensal> getGerenciadoraMensal() {
    return gerenciadoraMensal;
}

public void setGerenciadoraMensal(List<GerenciadoraMensal> gerenciadoraMensal) {
    this.gerenciadoraMensal = gerenciadoraMensal;
}
}
