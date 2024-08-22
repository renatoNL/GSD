package start.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioSonhoService relatorioSonhoService;

    @GetMapping("/sonhos")
    public List<RelatorioSonho> getRelatorioSonhos() {
        return relatorioSonhoService.gerarRelatorio();
    }
}
