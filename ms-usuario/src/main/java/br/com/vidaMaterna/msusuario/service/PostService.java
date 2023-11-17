package br.com.vidaMaterna.msusuario.service;

import br.com.vidaMaterna.msusuario.dto.PostDTO;
import br.com.vidaMaterna.msusuario.model.Post;
import br.com.vidaMaterna.msusuario.model.Usuario;
import br.com.vidaMaterna.msusuario.repository.PostsRepository;
import br.com.vidaMaterna.msusuario.repository.UsuarioRepository;
import br.com.vidaMaterna.msusuario.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

  @Autowired
  private PostsRepository postsRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Transactional
  public List<PostDTO> findAll() {
    return postsRepository.findAll().stream().map(PostDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public PostDTO findById(long postId) {
    Post post = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));

    return new PostDTO(post);
  }

  @Transactional
  public PostDTO insert(long usuarioId,PostDTO postDTO) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + usuarioId));
    Post post = new Post();
    post.setNome(postDTO.getNome());
    post.setDescricao(postDTO.getDescricao());
    post.setConteudo(postDTO.getConteudo());
    post.setUsuario(usuario);

    List<Post> posts = usuario.getPosts();
    posts.add(post);
    usuario.setPosts(posts);

    postsRepository.save(post);
    usuarioRepository.save(usuario);

    return new PostDTO(post);
  }

  @Transactional
  public PostDTO update(long postId,PostDTO postDTO) {
    Post post = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));
    post.setNome(postDTO.getNome());
    post.setDescricao(postDTO.getDescricao());
    post.setConteudo(postDTO.getConteudo());
    return new PostDTO(post);
  }

  @Transactional
  public void delete(long postId) {
    Post post = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));
    postsRepository.delete(post);
  }
}
