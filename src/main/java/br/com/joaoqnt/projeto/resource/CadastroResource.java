package br.com.joaoqnt.projeto.resource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joaoqnt.projeto.dto.CadastroDto;

@Controller
public class CadastroResource {

    private List<CadastroDto> cadastros = new ArrayList<>();

    @PostMapping("cadastroPost")
    public String doPost(CadastroDto dto, Model model) {
        cadastros.add(dto);
        return doGet(model);
    }

    @RequestMapping("cadastroGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        return "lista";
    }

    @RequestMapping("cadastroResourceUpdate")
    public String doUpdate(
        Model model,
        String oldName,
        String newName,
        String oldEmail,
        String newEmail,
        String oldTel,
        String newTel
    ) {
        for (CadastroDto cadastro : cadastros) {
            if (cadastro.getName().equals(oldName)) {
                cadastro.setName(newName); 
                cadastro.setEmail(newEmail); 
                cadastro.setNumber(newTel); 
                break; 
            }
        }
    
        return doGet(model);
    }

    @RequestMapping("cadastroDelete")
    public String doDelete(Model model, String name) {

        for (CadastroDto cadastro : cadastros) {
            if (cadastro.getName().equals(name)) {
                cadastros.remove(cadastro);
                break;
            }
        }

        return doGet(model);
    }
}
