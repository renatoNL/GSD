package start.DTO;

import jakarta.validation.constraints.NotNull;

public record PrevidenciaDTO(@NotNull int idadeInicial,@NotNull int idadeAposentadoria) {

    

}
