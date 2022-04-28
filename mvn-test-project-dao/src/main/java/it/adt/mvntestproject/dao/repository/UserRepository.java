package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findById(int id_user);
}
