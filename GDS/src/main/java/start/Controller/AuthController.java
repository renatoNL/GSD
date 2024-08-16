package start.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import start.Infra.Segurity.TokenService;
import start.Model.UsuarioModel;
import start.Repository.UsuarioRepository;
import start.dto.LoginRequestDTO;
import start.dto.RegisterRequestDTO;
import start.dto.ResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        UsuarioModel usuarioModel = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), usuarioModel.getPassword())) {
            String token = this.tokenService.generateToken(usuarioModel);
            return ResponseEntity.ok(new ResponseDTO(usuarioModel.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<UsuarioModel> usuarioModel = this.repository.findByEmail(body.email());
        if(usuarioModel.isEmpty()) {
            UsuarioModel newUsuario = new UsuarioModel();
            newUsuario.setPassword(passwordEncoder.encode(body.password()));
            newUsuario.setEmail(body.email());
            newUsuario.setName(body.name());
            this.repository.save(newUsuario);
    
            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(newUsuario.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
