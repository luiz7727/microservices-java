package br.com.vidaMaterna.msusuario.repository;

import br.com.vidaMaterna.msusuario.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
