package it.adt.comparison.repository;

import it.adt.comparison.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
