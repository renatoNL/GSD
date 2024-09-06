package start.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import start.Model.Sonho;
import start.Service.SonhoService;

@RestController
@RequestMapping("/sonho")
public class SonhoController {

    @Autowired
    private SonhoService sonhoService;

    @GetMapping("/") // olha para aqui //
    public List<Sonho> getAllSonhos() {
        return sonhoService.findAll();
    }

    @GetMapping("/{id}")
    public Sonho getSonhoById(@PathVariable Long id) {
        return sonhoService.findById(id);
    }

    @PostMapping("/simular")
    public ResponseEntity<Map<String, Double>> simularSonho(@RequestBody Sonho sonho) {
        Map<String, Double> resultado = sonhoService.simularInvestimento(sonho);
        return ResponseEntity.ok(resultado);
    }
    
    @PostMapping("/createsonho")
    public ResponseEntity<Sonho> createSonho(@RequestBody Sonho sonho) {
        Sonho novoSonho = sonhoService.createSonho(sonho);
        return ResponseEntity.ok(novoSonho);
    }

    @GetMapping("/gestaodesonhos")
    public ModelAndView gestaoDeSonhos(@RequestParam Long id) {
        Sonho sonho = sonhoService.findById(id);
        ModelAndView mav = new ModelAndView("gestaodesonhos");
        mav.addObject("sonho", sonho);
        return mav;
    }

    @PutMapping("/{id}")
    public Sonho updateSonho(@PathVariable Long id, @RequestBody Sonho sonhoAtualizado) {
        return sonhoService.updateSonho(id, sonhoAtualizado);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSonho(@PathVariable Long id) {
        return sonhoService.deleteSonho(id);
    }
}
