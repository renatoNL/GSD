package start.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.Repository.UsuarioRepository;
import start.Model.UsuarioModel;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel criarUsuario (UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel findById(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public UsuarioModel updateUsuario(Long id, UsuarioModel usuarioAtualizado) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioModel usuarioExistente = usuarioOptional.get();
            usuarioExistente.setName(usuarioAtualizado.getName());
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
            usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
            usuarioExistente.setCelular(usuarioAtualizado.getCelular());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setPassword(usuarioAtualizado.getPassword());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
