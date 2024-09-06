package start.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import start.Model.UsuarioModel;
import start.Repository.UsuarioRepository;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "cadastro";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UsuarioModel newUser, RedirectAttributes redirectAttributes, Model model) {
        if (repository.findByEmail(newUser.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered");
            return "cadastro";
        }

        try {
            repository.save(newUser);
            redirectAttributes.addFlashAttribute("success", "Registration successful. Please log in.");
            return "redirect:/auth/login";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during registration. Please try again.");
            return "cadastro";
        }
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute UsuarioModel usuarioLogin, HttpSession sessao, RedirectAttributes atributosRedirecionamento, Model modelo) {
        UsuarioModel usuario = repository.findByEmail(usuarioLogin.getEmail())
                .orElse(null);
    
        if (usuario == null) {
            modelo.addAttribute("erro", "Credenciais inválidas");
            return "login";
        }
    
        sessao.setAttribute("idUsuario", usuario.getId());
        atributosRedirecionamento.addFlashAttribute("sucesso", "Login realizado com sucesso");
        return "redirect:/servicos";
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }
}