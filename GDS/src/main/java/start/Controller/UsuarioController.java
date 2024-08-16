package start.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import start.Model.UsuarioModel;
import start.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> listarUsuario (){
        return usuarioService.listarUsuario();
    }
    @PostMapping
    public UsuarioModel CriarUsuario(@RequestBody UsuarioModel usario){
        return usuarioService.criarUsuario(usario);
    }

    @GetMapping("/{id}")
    public UsuarioModel getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado) {
        return usuarioService.updateUsuario(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void DeletarUsiario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
    
    @RestController
@RequestMapping("/usuario")
public class UserController {
    @GetMapping
    public ResponseEntity<String> getUsuario(){
        return ResponseEntity.ok("sucesso!");
    }
}
    }



