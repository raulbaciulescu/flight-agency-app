package group.travelagency.repository;


import group.travelagency.domain.Entity;

import java.util.List;
import java.util.Optional;

public interface Repository<ID, T extends Entity<ID>> {
    void add(T entity);
    void update (T entity);
    Optional<T> findByID(ID id);
    void delete(ID id);
    List<T> getAll();
}