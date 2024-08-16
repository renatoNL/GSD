package start.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.Optional;
import start.Model.GerenciadoraMensal;
import start.Service.GerenciadoraMensalService;

@RestController
@RequestMapping("/gerenciadora")
public class GerenciadoraMensalController {

    @Autowired
    private GerenciadoraMensalService gerenciadoraMensalService;

    @PostMapping
    public GerenciadoraMensal criarGerenciadoraMensal(@RequestBody GerenciadoraMensal gerenciadora) {
        return gerenciadoraMensalService.criarGerenciadoraMensal(gerenciadora);
    }

    @GetMapping("/{mesAno}")
    public Optional<GerenciadoraMensal> buscarPorMesAno(@PathVariable String mesAno) {
        YearMonth yearMonth = YearMonth.parse(mesAno);
        return gerenciadoraMensalService.buscarPorMesAno(yearMonth);
    }

    @PutMapping("/{id}")
    public GerenciadoraMensal atualizarGerenciadoraMensal(@PathVariable YearMonth id, @RequestBody GerenciadoraMensal gerenciadoraAtualizada) {
        return gerenciadoraMensalService.atualizarGerenciadoraMensal(id, gerenciadoraAtualizada);
    }

    @DeleteMapping("/{id}")
    public boolean deletarGerenciadoraMensal(@PathVariable Long id) {
        return gerenciadoraMensalService.deletarGerenciadoraMensal(id);
    }

}