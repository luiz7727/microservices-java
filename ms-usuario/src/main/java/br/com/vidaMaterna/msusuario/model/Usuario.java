package br.com.vidaMaterna.msusuario.model;

import javax.persistence.*;


@Entity
@Table(name = "tb_usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;
  private String email;
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
