package br.com.vidamaterna.mspost.http;

import br.com.vidamaterna.mspost.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("ms-usuario")
public interface UsuarioClient {

  @GetMapping("/usuarios/{id}")
  Optional<UsuarioDTO> pegarUsuarioPeloId(@PathVariable(name = "id") Long id);
}
