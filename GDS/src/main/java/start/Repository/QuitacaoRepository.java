package start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import start.Model.Quitacao;

public interface QuitacaoRepository extends JpaRepository<Quitacao, Long> {

}
