package start.Model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
private String email; //add chave unica //verificar o email
private String password;

public UsuarioModel() {
}


public UsuarioModel(Long id, String name, String cpf, LocalDate dataNascimento, String celular, String email,
        String password) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.celular = celular;
    this.email = email;
    this.password = password;
}


public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
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


public String getName() {
    return name;
}


public void setName(String name) {
    this.name = name;
}


}
