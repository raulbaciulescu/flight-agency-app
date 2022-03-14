package group.travelagency.repository;


import group.travelagency.domain.Entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<ID, T extends Entity<ID>> {
    void add(T entity);
    void update (T entity);
    Optional<T> findByID(ID id) throws SQLException;
    void delete(ID id);
    List<T> getAll();
}