package br.com.vidamaterna.mspost.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

  private long id;
  private String nome;
  private String email;
  private String senha;

  private List<PostDTO> posts = new ArrayList<>();
  private List<ComentarioDTO> comentarios = new ArrayList<>();

  public UsuarioDTO() {

  }

  public UsuarioDTO(long id, String nome, String email, String senha, List<ComentarioDTO> comentarios, List<PostDTO> posts) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.comentarios = comentarios;
    this.posts = posts;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setPassword(String senha) {
    this.senha = senha;
  }

  public List<ComentarioDTO> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<ComentarioDTO> comentarios) {
    this.comentarios = comentarios;
  }

  public List<PostDTO> getPosts() {
    return posts;
  }

  public void setPosts(List<PostDTO> posts) {
    this.posts = posts;
  }
}
