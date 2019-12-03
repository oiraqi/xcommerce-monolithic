package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

/*import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.BaseEntity;

@CrossOrigin(origins = "http://localhost:4200")
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Long> {
    /*@Query("select e from E e where e.id = ?1 and e.active = true")
    Optional<E> findById(String name);

    @Query("select e from E e where e.active = false")
    List<E> findInactive();*/
}