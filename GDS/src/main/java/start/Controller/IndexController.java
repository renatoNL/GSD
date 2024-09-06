package start.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import start.Model.Sonho;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
<<<<<<< HEAD
        Map<String, String> imageMap = new HashMap<>();
        Sonho sonho = new Sonho();
        
        model.addAttribute("sonho", new Sonho("", 0.0, sonho.getPrazo()));
        model.addAttribute("logoRemove", "/imagens/logoimg3.png");
        model.addAttribute("pngwing", "/imagens/img2.png");
        model.addAttribute("designSemNome", "/imagens/img1.png");
        model.addAttribute("file", "/imagens/file.png");
        model.addAttribute("designSemNome6", "/imagens/Design sem nome (6) 1.png");
        model.addAttribute("designSemNome23", "/imagens/Design sem nome (23) 1.png");
        model.addAttribute("designSemNome9", "/imagens/Design sem nome (9) 1.png");
=======
        model.addAttribute("sonho", new Sonho());
>>>>>>> 4b7b6820be166b090b0ab84e2787dd868eaeeeca
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

