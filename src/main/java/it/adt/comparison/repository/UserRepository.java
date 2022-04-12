package it.adt.comparison.repository;

import it.adt.comparison.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    /*
    @Query("SELECT * FROM User WHERE firstName= :mio_nome")
    List<User> findMio(@Param("mio_nome") String name);
     */
}
