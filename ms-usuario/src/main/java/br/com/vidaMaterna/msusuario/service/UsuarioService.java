package br.com.vidaMaterna.msusuario.service;

import br.com.vidaMaterna.msusuario.dto.ComentarioDTO;
import br.com.vidaMaterna.msusuario.dto.PostDTO;
import br.com.vidaMaterna.msusuario.dto.UsuarioDTO;
import br.com.vidaMaterna.msusuario.http.PostClient;
import br.com.vidaMaterna.msusuario.model.Usuario;
import br.com.vidaMaterna.msusuario.repository.UsuarioRepository;
import br.com.vidaMaterna.msusuario.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private PostClient postClient;


  @Transactional
  public List<UsuarioDTO> findAll() {
    return usuarioRepository.findAll().stream().map((usuario) -> new UsuarioDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha(),
            postClient.pegarTodosComentariosPeloUsuarioId(usuario.getId()).getBody(),
            postClient.pegarTodosPostPeloUsuarioId(usuario.getId()).getBody())).collect(Collectors.toList());
  }

  @Transactional
  public UsuarioDTO findById(long usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + usuarioId));
    // Get all posts from user
    List<PostDTO> posts = postClient.pegarTodosPostPeloUsuarioId(usuarioId).getBody();

    // Get all comments from user
    List<ComentarioDTO> comentarios = postClient.pegarTodosComentariosPeloUsuarioId(usuarioId).getBody();

    return new UsuarioDTO(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getSenha(),comentarios,posts);
  }

  @Transactional
  public UsuarioDTO insert(UsuarioDTO usuarioDTO) {
    Usuario usuario = new Usuario(usuarioDTO.getNome(),usuarioDTO.getEmail(),usuarioDTO.getSenha());
    usuarioRepository.save(usuario);

    return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
  }
  @Transactional
  public UsuarioDTO update(long usuarioId,UsuarioDTO usuarioDTO) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + usuarioId));
    usuario.setNome(usuarioDTO.getNome());
    usuario.setEmail(usuarioDTO.getEmail());
    usuario.setPassword(usuarioDTO.getSenha());
    usuarioRepository.save(usuario);

    return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
  }

  @Transactional
  public void delete(long usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + usuarioId));
    usuarioRepository.delete(usuario);
  }

}
