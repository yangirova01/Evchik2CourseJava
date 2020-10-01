package postgres_homework;

import java.util.List;


public interface CrudRepository<T> {
    List<T> findAll();
    List<List<T>> findAllByAge(Integer age);
}