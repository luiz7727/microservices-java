package br.com.vidaMaterna.msusuario.dto;

import javax.validation.constraints.NotNull;

public class ComentarioDTO {

  private long id;
  @NotNull(message = "O comentário é obrigatório")
  private String nome;

  public ComentarioDTO() {

  }

  public ComentarioDTO(long id,String nome) {
    this.id = id;
    this.nome = nome;
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
}
