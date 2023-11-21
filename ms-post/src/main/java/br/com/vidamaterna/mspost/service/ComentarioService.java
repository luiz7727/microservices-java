package br.com.vidamaterna.mspost.service;

import br.com.vidamaterna.mspost.dto.ComentarioDTO;
import br.com.vidamaterna.mspost.dto.UsuarioDTO;
import br.com.vidamaterna.mspost.http.UsuarioClient;
import br.com.vidamaterna.mspost.model.Comentario;
import br.com.vidamaterna.mspost.model.Post;
import br.com.vidamaterna.mspost.repository.ComentarioRepository;
import br.com.vidamaterna.mspost.repository.PostRepository;
import br.com.vidamaterna.mspost.service.exception.ResourceNotFoundException;
import br.com.vidamaterna.mspost.service.exception.ServerNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  @Autowired
  private PostRepository postsRepository;

  @Autowired
  private UsuarioClient usuarioClient;

  @Transactional
  public List<ComentarioDTO> findAll() {
    return comentarioRepository.findAll().stream().map(ComentarioDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public List<ComentarioDTO> findAllComentariosDeUmUsuario(long usuarioId) {
    return comentarioRepository.findAllByUsuarioId(usuarioId).stream().map(ComentarioDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public ComentarioDTO findById(long comentarioId) {
    Comentario comentario = comentarioRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException("comentário não encontrado. ID: " + comentarioId));

    return new ComentarioDTO(comentario);
  }

  @Transactional
  public ComentarioDTO insert(long postId,long usuarioId, ComentarioDTO comentarioDTO) {
    ResponseEntity<UsuarioDTO> responseEntity = usuarioClient.pegarUsuarioPeloId(usuarioId);


    if(responseEntity.getStatusCode().value() == 503) {
      throw new ServerNotAvailableException("0 ms-usuario precisa estar ligado para funcionar");
    }

    if(responseEntity.getStatusCode().value() == 404) {
      throw new ResourceNotFoundException("Usuário não encontrado: ID " + usuarioId);
    }

    Post post = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post não encontrado. ID: " + usuarioId));

    Comentario comentario = new Comentario(comentarioDTO.getNome(),responseEntity.getBody().getId(),post);
    comentarioRepository.save(comentario);

    post.getComentarios().add(comentario);

    comentarioRepository.save(comentario);
    return new ComentarioDTO(comentario);
  }
  @Transactional
  public ComentarioDTO update(long comentarioId,ComentarioDTO comentarioDTO) {
    Comentario comentario = comentarioRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException("comentário não encontrado. ID: " + comentarioId));
    comentario.setNome(comentarioDTO.getNome());
    return new ComentarioDTO(comentario);
  }

  @Transactional
  public void delete(long comentarioId) {
    Comentario comentario = comentarioRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException("comentário não encontrado. ID: " + comentarioId));
    comentarioRepository.delete(comentario);
  }
}
