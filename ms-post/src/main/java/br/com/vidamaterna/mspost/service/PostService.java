package br.com.vidamaterna.mspost.service;

import br.com.vidamaterna.mspost.dto.PostDTO;
import br.com.vidamaterna.mspost.dto.UsuarioDTO;
import br.com.vidamaterna.mspost.http.UsuarioClient;
import br.com.vidamaterna.mspost.model.Post;
import br.com.vidamaterna.mspost.repository.ComentarioRepository;
import br.com.vidamaterna.mspost.repository.PostRepository;
import br.com.vidamaterna.mspost.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;


  @Autowired
  private UsuarioClient usuarioClient;

  @Transactional
  public List<PostDTO> findAll() {
    return postRepository.findAll().stream().map(PostDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public List<PostDTO> findAllPeloUsuarioId(long usuarioId) {
    return postRepository.findAllByUsuarioId(usuarioId).stream().map(PostDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public PostDTO findById(long postId) {
    Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));

    return new PostDTO(post);
  }

  @Transactional
  public PostDTO insert(long usuarioId,PostDTO postDTO) {
    ResponseEntity responseEntity = usuarioClient.pegarUsuarioPeloId(usuarioId);

    if(responseEntity.getStatusCode().value() == 404) {
      throw new ResourceNotFoundException("Usuário não encontrado: ID " + usuarioId);
    }

    Post post = new Post();
    post.setNome(postDTO.getNome());
    post.setDescricao(postDTO.getDescricao());
    post.setConteudo(postDTO.getConteudo());
    post.setUsuarioId(usuarioId);

    postRepository.save(post);

    return new PostDTO(post);
  }

  @Transactional
  public PostDTO update(long postId,PostDTO postDTO) {
    Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));
    post.setNome(postDTO.getNome());
    post.setDescricao(postDTO.getDescricao());
    post.setConteudo(postDTO.getConteudo());
    return new PostDTO(post);
  }

  @Transactional
  public void delete(long postId) {
    Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post não encontrado. ID: " + postId));
    postRepository.delete(post);
  }


}
