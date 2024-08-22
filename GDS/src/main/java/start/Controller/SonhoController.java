package start.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import start.Model.Sonho;
import org.springframework.web.bind.annotation.RestController;

import start.Service.SonhoService;

@RestController
@RequestMapping("/sonho")
public class SonhoController {

    @Autowired
    private SonhoService sonhoService;

    @GetMapping
    public List<Sonho> getAllSonhos() {
        return sonhoService.findAll();
    }

    @GetMapping("/{id}")
    public Sonho getSonhoById(@PathVariable Long id) {
        return sonhoService.findById(id);
    }

    @PostMapping
    public Sonho createSonho(@RequestBody Sonho sonho) {
        return sonhoService.createSonho(sonho);
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
