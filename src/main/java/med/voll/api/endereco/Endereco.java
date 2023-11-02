package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

  private String logradouro;
  private String bairro;
  private String cep;
  private String uf;
  private String cidade;
  private String complemento;
  private Integer numero;

  public Endereco(DadosEndereco dados) {

    this.logradouro = dados.logradouro();
    this.bairro = dados.bairro();
    this.cep = dados.cep();
    this.cidade = dados.cidade();
    this.complemento = dados.complemento();
    this.uf = dados.uf();
    this.numero = dados.numero();
  }
}