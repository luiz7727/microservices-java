package br.com.vidamaterna.mspost.dto;

import br.com.vidamaterna.mspost.model.Post;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {

  private long id;

  @NotNull(message = "O nome do post é obrigatório")
  private String nome;

  @NotNull(message = "A descrição é obrigatória")
  private String descricao;

  @NotNull(message = "O conteúdo do post obrigatório")
  private String conteudo;

  private List<ComentarioDTO> comentarios = new ArrayList<>();


  public PostDTO() {

  }

  public PostDTO(long id, String nome, String descricao, String conteudo, List<ComentarioDTO> comentarios) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.conteudo = conteudo;
    this.comentarios = comentarios;
  }

  public PostDTO(Post entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.descricao = entity.getDescricao();
    this.conteudo = entity.getConteudo();
    this.comentarios = entity.getComentarios().stream().map((comentario -> new ComentarioDTO(comentario.getId(),comentario.getNome()))).collect(Collectors.toList());
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public List<ComentarioDTO> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<ComentarioDTO> comentarios) {
    this.comentarios = comentarios;
  }
}
