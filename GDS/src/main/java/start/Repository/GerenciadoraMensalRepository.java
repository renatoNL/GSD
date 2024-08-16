package start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.YearMonth;
import start.Model.GerenciadoraMensal;
import java.util.Optional;

public interface GerenciadoraMensalRepository extends JpaRepository<GerenciadoraMensal, Long> {
Optional<GerenciadoraMensal> findByMesAno(YearMonth mesAno);
}
