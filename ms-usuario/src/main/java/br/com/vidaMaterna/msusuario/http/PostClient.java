package br.com.vidaMaterna.msusuario.http;

import br.com.vidaMaterna.msusuario.dto.ComentarioDTO;
import br.com.vidaMaterna.msusuario.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("ms-post")
public interface PostClient {

  @GetMapping("/posts/findAllPostsDeUmUsuario/{usuarioId}")
  ResponseEntity<List<PostDTO>> pegarTodosPostPeloUsuarioId(@PathVariable(name = "usuarioId") long usuarioId);

  @GetMapping("/comentarios/findAllComentariosDeUmUsuario/{usuarioId}")
  ResponseEntity<List<ComentarioDTO>> pegarTodosComentariosPeloUsuarioId(@PathVariable(name = "usuarioId") long usuarioId);
}
