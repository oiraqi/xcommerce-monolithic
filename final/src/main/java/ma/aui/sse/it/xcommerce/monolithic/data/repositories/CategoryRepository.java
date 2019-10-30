package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Omar IRAQI
 */
@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
