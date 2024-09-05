package start.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import start.Infra.Segurity.TokenService;
import start.Model.UsuarioModel;
import start.Repository.UsuarioRepository;
import start.dto.LoginRequestDTO;
import start.dto.RegisterRequestDTO;
import start.dto.ResponseDTO;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
public String login(@RequestParam String email, @RequestParam String password, Model model) {
    try {
        UsuarioModel usuario = repository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (passwordEncoder.matches(password, usuario.getPassword())) {
            String token = tokenService.generateToken(usuario);
            return "redirect:/servicos";
        } else {
            model.addAttribute("error", "Email ou senha incorretos");
            return "login";
        }
    } catch (RuntimeException e) {
        model.addAttribute("error", "Email ou senha incorretos");
        return "login";
    }
}

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO data) {
        if(this.repository.findByEmail(data.email()).isPresent()) return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(data.password());
        UsuarioModel newUser = new UsuarioModel();
        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(encryptedPassword);
        newUser.setCpf(data.cpf());
        newUser.setDataNascimento(data.dataNascimento());
        newUser.setCelular(data.celular());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/register")
    public String registerPage() {
        return "cadastro";
    }
}

