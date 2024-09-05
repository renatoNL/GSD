package start.dto;

import java.time.LocalDate;

public record RegisterRequestDTO (String name, String email, String password) {

    public String cpf() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cpf'");
    }

    public LocalDate dataNascimento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dataNascimento'");
    }

    public String celular() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'celular'");
    }
}
