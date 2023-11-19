package br.com.vidamaterna.mspost.controller;

import br.com.vidamaterna.mspost.dto.PostDTO;
import br.com.vidamaterna.mspost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
  public ResponseEntity<PostDTO> findById(@PathVariable(name = "id") long id) {
    PostDTO post = postService.findById(id);
    return ResponseEntity.ok(post);
  }

  @GetMapping("/findAllPostsDeUmUsuario/{usuarioId}")
  public ResponseEntity<List<PostDTO>> findAllPeloUsuarioId(@PathVariable(name = "usuarioId") long usuarioId) {
    List<PostDTO> posts = postService.findAllPeloUsuarioId(usuarioId);
    return ResponseEntity.ok(posts);
  }

  @PostMapping()
  public ResponseEntity<PostDTO> insert(@RequestParam(name = "usuarioId") long usuarioId,@Valid @RequestBody PostDTO postDTO) {
    PostDTO post = postService.insert(usuarioId,postDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(post.getId())
            .toUri();
    return ResponseEntity.created(uri).body(post);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PostDTO> update(@PathVariable @Valid @Positive Long id, @Valid @RequestBody PostDTO postDTO) {
    PostDTO postDto = postService.update(id, postDTO);
    return ResponseEntity.ok(postDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    postService.delete(id);

    return ResponseEntity.noContent().build();
  }
}
