package br.com.vidaMaterna.msusuario.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_comentario")
public class Comentario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  @ManyToOne(optional = false)
  private Usuario usuario;

  @ManyToOne(optional = false)
  private Post post;

  public Comentario() {

  }
  public Comentario(String nome, Usuario usuario, Post post) {
    this.nome = nome;
    this.usuario = usuario;
    this.post = post;
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

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Post getPosts() {
    return post;
  }

  public void setPosts(Post post) {
    this.post = post;
  }
}
