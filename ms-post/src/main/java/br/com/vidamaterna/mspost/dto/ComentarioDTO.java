package br.com.vidamaterna.mspost.dto;

import br.com.vidamaterna.mspost.model.Comentario;

public class ComentarioDTO {

  private long id;
  private String nome;
  private long usuarioId;
  public ComentarioDTO() {

  }

  public ComentarioDTO(long id,String nome, long usuarioId) {
    this.id = id;
    this.nome = nome;
    this.usuarioId = usuarioId;
  }

  public ComentarioDTO(Comentario entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.usuarioId = entity.getUsuarioId();
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

  public long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(long usuarioId) {
    this.usuarioId = usuarioId;
  }
}
