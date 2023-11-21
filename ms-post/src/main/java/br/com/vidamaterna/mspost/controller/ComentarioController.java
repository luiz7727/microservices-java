package br.com.vidamaterna.mspost.controller;

import br.com.vidamaterna.mspost.dto.ComentarioDTO;
import br.com.vidamaterna.mspost.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

  @Autowired
  private ComentarioService comentarioService;

  @GetMapping()
  public ResponseEntity<List<ComentarioDTO>> findAll() {
    List<ComentarioDTO> posts = comentarioService.findAll();
    return ResponseEntity.ok(posts);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ComentarioDTO> findById(@PathVariable(name = "id") @Valid @Positive(message = "O id do comentário precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: '/comentarios/1' ") long id) {
    ComentarioDTO comentario = comentarioService.findById(id);
    return ResponseEntity.ok(comentario);
  }

  @GetMapping("/findAllComentariosDeUmUsuario/{usuarioId}")
  public ResponseEntity<List<ComentarioDTO>> findAllComentariosDeUmUsuario(@PathVariable(name = "usuarioId") @Valid @Positive(message = "o id do usuário precisa ser positivo") @NotNull(message = "Informe o id do usuário na url, Ex: '/comentarios/findAllComentariosDeUmUsuario/1' ") long usuarioId) {
    List<ComentarioDTO> posts = comentarioService.findAllComentariosDeUmUsuario(usuarioId);
    return ResponseEntity.ok(posts);
  }

  @PostMapping()
  public ResponseEntity<ComentarioDTO> insert(
          @RequestParam(name = "postId") @Valid @Positive(message = "O id do post precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: 'comentarios?postId=1&usuarioId=1' ") long postId,
          @RequestParam(name = "usuarioId") @Valid @Positive(message = "O id do usuário precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: 'comentarios?usuarioId=1&postId=1' ") long usuarioId,
          @Valid @RequestBody ComentarioDTO comentarioDTO) {
    ComentarioDTO comentario = comentarioService.insert(postId,usuarioId,comentarioDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(comentario.getId())
            .toUri();
    return ResponseEntity.created(uri).body(comentario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ComentarioDTO> update(@PathVariable @Valid @Positive(message = "O id do comentário precisa ser positivo") @NotNull(message = "Informe o id do comentário na url, Ex: 'comentarios/1' ") Long id, @Valid @RequestBody ComentarioDTO comentarioDTO) {
    ComentarioDTO comentario = comentarioService.update(id, comentarioDTO);
    return ResponseEntity.ok(comentario);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable @Valid @Positive(message = "O id do comentário precisa ser positivo") @NotNull(message = "Informe o id do comentário na url, Ex: 'comentarios/1' ") Long id) {
    comentarioService.delete(id);

    return ResponseEntity.noContent().build();
  }
}
