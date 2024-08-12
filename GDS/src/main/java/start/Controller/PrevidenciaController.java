package start.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import start.DTO.PrevidenciaDTO;
import start.Model.PrevidenciaModel;
import start.Repository.PrevidenciaRepository;

@RestController
@RequestMapping("/previdencia")
public class PrevidenciaController {

    @Autowired
    PrevidenciaRepository previdenciaRepository;

    @PostMapping("/previdencia")
    public ResponseEntity <PrevidenciaModel> savePrevidenciaRepository(@RequestBody @Valid PrevidenciaDTO previdenciaDTO){
        var previdenciaModel = new PrevidenciaModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(previdenciaRepository.save(previdenciaModel));
    }

    
    // na aula a mina sugeriu e usou o recurso do java "record" para implementar os
    // get, delet e etc... //

    

}