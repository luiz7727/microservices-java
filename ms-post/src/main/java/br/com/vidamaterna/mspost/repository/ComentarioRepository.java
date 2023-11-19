package br.com.vidamaterna.mspost.repository;

import br.com.vidamaterna.mspost.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

  List<Comentario> findAllByUsuarioId(long usuarioId);
}
