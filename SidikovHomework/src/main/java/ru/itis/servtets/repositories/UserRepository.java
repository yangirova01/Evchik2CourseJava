package ru.itis.servtets.repositories;
import ru.itis.servtets.model.User;
import java.util.Optional;
public interface UserRepository extends CrudRepository<User> {
    Optional <User> findByLogin(String login, String table);
    Boolean findUsersByLoginAndPassword(String email,String password, String table);
}