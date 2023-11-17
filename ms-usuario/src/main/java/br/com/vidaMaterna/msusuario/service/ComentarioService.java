package br.com.vidaMaterna.msusuario.service;

import br.com.vidaMaterna.msusuario.dto.ComentarioDTO;
import br.com.vidaMaterna.msusuario.model.Comentario;
import br.com.vidaMaterna.msusuario.model.Post;
import br.com.vidaMaterna.msusuario.model.Usuario;
import br.com.vidaMaterna.msusuario.repository.ComentarioRepository;
import br.com.vidaMaterna.msusuario.repository.PostsRepository;
import br.com.vidaMaterna.msusuario.repository.UsuarioRepository;
import br.com.vidaMaterna.msusuario.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private PostsRepository postsRepository;

  @Transactional
  public List<ComentarioDTO> findAll() {
    return comentarioRepository.findAll().stream().map(ComentarioDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public ComentarioDTO findById(long comentarioId) {
    Comentario comentario = comentarioRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException("comentário não encontrado. ID: " + comentarioId));

    return new ComentarioDTO(comentario);
  }

  @Transactional
  public ComentarioDTO insert(long postId,long usuarioId, ComentarioDTO comentarioDTO) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + usuarioId));
    Post post = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post não encontrado. ID: " + usuarioId));

    Comentario comentario = new Comentario();
    comentario.setNome(comentarioDTO.getNome());
    comentario.setUsuario(usuario);
    comentario.setPosts(post);
    comentarioRepository.save(comentario);

    List<Comentario> comentarios = post.getComentarios();
    comentarios.add(comentario);
    post.setComentarios(comentarios);

    postsRepository.save(post);
    usuarioRepository.save(usuario);
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
