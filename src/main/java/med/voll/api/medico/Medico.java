package med.voll.api.medico;

import java.time.LocalDateTime;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.controller.DadosAtualizacaoMedico;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String email;
  private String crm;
  private Boolean ativo;

  private String telefone;

  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;

  @Embedded
  private Endereco endereco;

  @CreationTimestamp
  private LocalDateTime data_criacao;

  public Medico(DadosCadastroMedico dados) {

    this.ativo = true;
    this.nome = dados.nome();
    this.email = dados.email();
    this.crm = dados.crm();
    this.telefone = dados.telefone();
    this.endereco = new Endereco(dados.endereco());
    this.especialidade = dados.especialidade();

  }

  public void atualizarInfo(@Valid DadosAtualizacaoMedico dados) {
    if (dados.nome() != null) {
      System.out.println("dados.nome() " + dados.nome());
      System.out.println("this.nome " + this.nome);
      this.nome = dados.nome();
      System.out.println("entrou aqui " + this.nome);

    }
    if (dados.telefone() != null) {
      this.telefone = dados.telefone();
    }
    if (dados.endereco() != null) {
      this.endereco.atualizarInfoEnd(dados.endereco());
    }

  }

  public void exlcuir() {
    this.ativo = false;

  }

}
