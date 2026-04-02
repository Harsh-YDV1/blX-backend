package com.bharat.legacyexplorer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class CrudService<T> {
    private final JpaRepository<T, Long> repository;

    public CrudService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> findAll() { return repository.findAll(); }
    public T save(T entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}
