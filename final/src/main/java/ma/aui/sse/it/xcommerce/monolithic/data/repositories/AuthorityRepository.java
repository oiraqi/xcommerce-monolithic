package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    List<Authority> findByAuthority(String authority);
}