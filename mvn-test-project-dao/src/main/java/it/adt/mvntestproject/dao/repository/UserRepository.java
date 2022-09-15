package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByIdUser(String idUser);
}
