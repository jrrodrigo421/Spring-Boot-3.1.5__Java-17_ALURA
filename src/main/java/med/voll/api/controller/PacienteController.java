package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

  @PostMapping("/")
  public void cadastrarPaciente(@RequestBody DadosCadastroPaciente json) {
    System.out.println(json);
  }

  @GetMapping("/")
  public String Ola() {
    return "Ola";
  }

}
