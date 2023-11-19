package br.com.vidamaterna.mspost.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_comentario")
public class Comentario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  private long usuarioId;

  @ManyToOne(optional = false)
  private Post post;

  public Comentario() {

  }
  public Comentario(String nome, long usuarioId, Post post) {
    this.nome = nome;
    this.usuarioId = usuarioId;
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

  public long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuario(long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public Post getPosts() {
    return post;
  }

  public void setPosts(Post post) {
    this.post = post;
  }
}
