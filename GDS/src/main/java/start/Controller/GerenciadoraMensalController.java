package start.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.List;
import start.Model.GerenciadoraMensal;
import start.Service.GerenciadoraMensalService;

@RestController
@RequestMapping("/gerenciadoraMensal")
public class GerenciadoraMensalController {

    @Autowired
    private GerenciadoraMensalService gerenciadoraMensalService;

    @GetMapping("/mes/{month}")
    public List<GerenciadoraMensal> buscarPorMes(@PathVariable int month) {
        return gerenciadoraMensalService.buscarPorMes(month);
    }

    @GetMapping("/ano/{year}")
    public List<GerenciadoraMensal> buscarPorAno(@PathVariable int year) {
        return gerenciadoraMensalService.buscarPorAno(year);
    }

    @GetMapping("/mesAno")
    public List<GerenciadoraMensal> buscarPorMesEAno(@RequestParam YearMonth masAno) {
        return gerenciadoraMensalService.buscarPorMesEAno(masAno);
    }

    @PostMapping("/criar")
    public GerenciadoraMensal criarGerenciadoraMensal(@RequestBody GerenciadoraMensal gerenciadoraMensal) {
        return gerenciadoraMensalService.criarGerenciadoraMensal(gerenciadoraMensal);
    }
    @PutMapping("/atualizar/{id}")
    public GerenciadoraMensal atualizarGerenciadoraMensal(@PathVariable Long id, @RequestBody GerenciadoraMensal gerenciadoraMensal) {
        return gerenciadoraMensalService.atualizarGerenciadoraMensal(id, gerenciadoraMensal);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarGerenciadoraMensal(@PathVariable Long id) {
        gerenciadoraMensalService.deletarGerenciadoraMensal(id);
    }
    @GetMapping("/progresso/{id}")
    public double calcularProgresso(@PathVariable Long id) {
        return gerenciadoraMensalService.calcularProgresso(id);
    }
}