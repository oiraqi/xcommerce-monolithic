package ma.aui.sse.it.xcommerce.monolithic.data.repositories;

import ma.aui.sse.it.xcommerce.monolithic.data.entities.User;

/**
 *
 * @author Omar IRAQI
 */
public interface UserRepository extends BaseRepository<User>{
    User findByUsername(String username);
}