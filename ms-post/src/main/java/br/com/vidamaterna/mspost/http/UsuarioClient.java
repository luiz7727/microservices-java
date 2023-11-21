package br.com.vidamaterna.mspost.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("ms-usuario")
public interface UsuarioClient {

  @GetMapping("/usuarios/{id}")
  ResponseEntity pegarUsuarioPeloId(@PathVariable(name = "id") Long id);
}
