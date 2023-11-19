package br.com.vidamaterna.mspost.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull(message = "O nome é obrigatório")
  private String nome;
  @NotNull(message = "A descrição é obrigatório")
  private String descricao;
  @NotNull(message = "O conteúdo é obrigatório")
  private String conteudo;

  private long usuarioId;

  @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "post")
  private List<Comentario> comentarios = new ArrayList<>();

  public Post() {

  }

  public Post(String nome, String descricao, String conteudo, long usuarioId, List<Comentario> comentarios) {
    this.nome = nome;
    this.descricao = descricao;
    this.conteudo = conteudo;
    this.usuarioId = usuarioId;
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

  public long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }
}