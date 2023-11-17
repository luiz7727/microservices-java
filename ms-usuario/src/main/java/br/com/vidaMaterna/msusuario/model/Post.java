package br.com.vidaMaterna.msusuario.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;
  private String descricao;
  private String conteudo;

  @ManyToOne(optional = false)
  private Usuario usuario;

  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "post")
  private List<Comentario> comentarios = new ArrayList<>();

  public Post() {

  }

  public Post(String nome, String descricao, String conteudo, Usuario usuario, List<Comentario> comentarios) {
    this.nome = nome;
    this.descricao = descricao;
    this.conteudo = conteudo;
    this.usuario = usuario;
    this.comentarios = comentarios;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }
}
