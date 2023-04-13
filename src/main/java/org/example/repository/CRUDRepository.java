package org.example.repository;

public interface CRUDRepository<T> {
    void save(T entity);

}
