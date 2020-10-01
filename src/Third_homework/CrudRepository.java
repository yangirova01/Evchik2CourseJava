package Third_homework;

import java.util.List;


public interface CrudRepository<T> {
    List<T> findAll();
    List<T> findAllByAge(Integer age);
}
