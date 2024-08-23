package start.Repository;

import start.Model.Sonho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SonhoRepository extends JpaRepository<Sonho, Long> {
}
