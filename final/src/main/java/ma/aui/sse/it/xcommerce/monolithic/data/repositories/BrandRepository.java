package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Brand;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Omar IRAQI
 */
@RepositoryRestResource
public interface BrandRepository extends BaseRepository<Brand> {
    
}
