package br.com.vidamaterna.mspost.controller;

import br.com.vidamaterna.mspost.dto.PostDTO;
import br.com.vidamaterna.mspost.service.PostService;
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
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping()
  public ResponseEntity<List<PostDTO>> findAll() {
    List<PostDTO> posts = postService.findAll();
    return ResponseEntity.ok(posts);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostDTO> findById(@PathVariable(name = "id") @Valid @Positive(message = "O id do post precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: '/posts/1' ") long id) {
    PostDTO post = postService.findById(id);
    return ResponseEntity.ok(post);
  }

  @GetMapping("/findAllPostsDeUmUsuario/{usuarioId}")
  public ResponseEntity<List<PostDTO>> findAllPeloUsuarioId(@PathVariable(name = "usuarioId") @Valid @Positive(message = "O id do usuário precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: '/posts/findAllPostsDeUmUsuario/1' ") long usuarioId) {
    List<PostDTO> posts = postService.findAllPeloUsuarioId(usuarioId);
    return ResponseEntity.ok(posts);
  }

  @PostMapping()
  public ResponseEntity<PostDTO> insert(@RequestParam(name = "usuarioId") @Valid @Positive(message = "O id do usuário precisa ser positivo") @NotNull(message = "Informe o id do usuário na url, Ex: '/posts/1' ") long usuarioId,@Valid @RequestBody PostDTO postDTO) {
    PostDTO post = postService.insert(usuarioId,postDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(post.getId())
            .toUri();
    return ResponseEntity.created(uri).body(post);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PostDTO> update(@PathVariable @Valid @Positive(message = "O id do post precisa ser positivo") @NotNull(message = "Informe o id do post na url, Ex: '/posts/1' ") Long id, @Valid @RequestBody PostDTO postDTO) {
    PostDTO postDto = postService.update(id, postDTO);
    return ResponseEntity.ok(postDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable @Valid @Positive(message = "O id do post precisa ser positivo") @NotNull(message = "Informe o ") Long id) {
    postService.delete(id);

    return ResponseEntity.noContent().build();
  }
}
