package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import java.util.List;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.Authority;

public interface AuthorityRepository extends BaseRepository<Authority> {
    List<Authority> findByAuthority(String authority);
}