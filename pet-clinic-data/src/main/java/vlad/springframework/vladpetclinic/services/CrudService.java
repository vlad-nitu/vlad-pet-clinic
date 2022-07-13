package vlad.springframework.vladpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID>{
    //uses Java generics to allow each Service to use its own needed type
    Set<T> findAll();
    T findById(ID id);
    T save (T obj);
    void delete(T obj);
}
