package br.com.vidamaterna.mspost.dto;

import br.com.vidamaterna.mspost.model.Comentario;

public class ComentarioDTO {

  private long id;
  private String nome;

  public ComentarioDTO() {

  }

  public ComentarioDTO(long id,String nome) {
    this.id = id;
    this.nome = nome;
  }

  public ComentarioDTO(Comentario entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
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
