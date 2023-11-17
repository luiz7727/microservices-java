package br.com.vidaMaterna.msusuario.dto;

import br.com.vidaMaterna.msusuario.model.Usuario;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

  private long id;

  @NotNull(message = "O nome é obrigatório")
  private String nome;
  @NotNull(message = "O email é obrigatório")
  private String email;
  @NotNull(message = "A senha é obrigatória")
  private String senha;

  private List<ComentarioDTO> comentarios = new ArrayList<>();
  private List<PostDTO> posts = new ArrayList<>();

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

  public UsuarioDTO(Usuario entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.email = entity.getEmail();
    this.senha = entity.getSenha();
    this.comentarios = entity.getComentarios().stream().map(ComentarioDTO::new).collect(Collectors.toList());
    this.posts = entity.getPosts().stream().map(PostDTO::new).collect(Collectors.toList());
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
