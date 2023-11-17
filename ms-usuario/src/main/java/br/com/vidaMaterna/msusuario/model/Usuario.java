package br.com.vidaMaterna.msusuario.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;
  private String email;
  private String senha;

  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "usuario")
  private List<Comentario> comentarios = new ArrayList<>();

  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "usuario")
  private List<Post> posts = new ArrayList<>();

  public Usuario() {

  }

  public Usuario(String nome,String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }
  public Usuario(String nome, String email, String senha, List<Comentario> comentarios, List<Post> posts) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.comentarios = comentarios;
    this.posts = posts;
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

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}
