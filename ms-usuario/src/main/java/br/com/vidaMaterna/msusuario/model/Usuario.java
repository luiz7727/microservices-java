package br.com.vidaMaterna.msusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull(message = "O nome é obrigatório")
  private String nome;
  @NotNull(message = "O email é obrigatório")
  private String email;
  @NotNull(message = "A senha é obrigatória")

  private String senha;


  public Usuario() {

  }

  public Usuario(String nome,String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }


  public long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setPassword(String password) {
    this.senha = password;
  }

}
