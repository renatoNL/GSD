package start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import start.Model.GerenciadoraMensal;

import java.util.List;


@Repository
public interface GerenciadoraMensalRepository extends JpaRepository<GerenciadoraMensal, Long> {

    List<GerenciadoraMensal> findByMasAnoMonth(int month);

    List<GerenciadoraMensal> findByMasAnoYear(int year);

    List<GerenciadoraMensal> findByMasAno(YearMonth masAno);
}
