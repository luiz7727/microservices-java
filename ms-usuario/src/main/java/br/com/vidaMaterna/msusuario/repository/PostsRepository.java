package br.com.vidaMaterna.msusuario.repository;

import br.com.vidaMaterna.msusuario.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post,Long> {
}
