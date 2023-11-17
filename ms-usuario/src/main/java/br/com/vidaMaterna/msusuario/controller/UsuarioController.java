package br.com.vidaMaterna.msusuario.controller;

import br.com.vidaMaterna.msusuario.dto.UsuarioDTO;
import br.com.vidaMaterna.msusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping()
  public ResponseEntity<List<UsuarioDTO>> findAll() {
    List<UsuarioDTO> usuarios = usuarioService.findAll();
    return ResponseEntity.ok(usuarios);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDTO> findById(@PathVariable(name = "id") long id) {
    UsuarioDTO usuario = usuarioService.findById(id);
    return ResponseEntity.ok(usuario);
  }

  @PostMapping
  public ResponseEntity<UsuarioDTO> insert(@Valid @RequestBody UsuarioDTO usuarioDTO) {
    UsuarioDTO usuario = usuarioService.insert(usuarioDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(usuario.getId())
            .toUri();
    return ResponseEntity.created(uri).body(usuario);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDTO> update(@PathVariable @Valid @Positive Long id, @Valid @RequestBody UsuarioDTO clienteDTO) {
    UsuarioDTO usuarioDTO = usuarioService.update(id, clienteDTO);
    return ResponseEntity.ok(usuarioDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    usuarioService.delete(id);

    return ResponseEntity.noContent().build();
  }

}
