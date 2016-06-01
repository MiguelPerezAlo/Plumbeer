package plumbeer.dev.repository;

import plumbeer.dev.domain.Post;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Post entity.
 */
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select post from Post post where post.autor.login = ?#{principal.username}")
    List<Post> findByAutorIsCurrentUser();

}
