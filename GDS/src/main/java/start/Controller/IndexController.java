package start.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import start.Model.Sonho;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sonho", new Sonho());
        return "index";
    }

    @GetMapping("/gestao-sonhos")
    public String gestaoSonhos(Model model) {
        Map<String, String> imageMap = new HashMap<>();
        Sonho sonho = new Sonho();
        model.addAttribute("sonho", new Sonho("", 0.0, sonho.getPrazo()));
        model.addAttribute("logoRemove", "/imagens/logoimg3.png");
        model.addAttribute("pngwing", "/imagens/img2.png");
        model.addAttribute("designSemNome", "/imagens/img1.png");
        return "gestaodesonhos";
    }


}
