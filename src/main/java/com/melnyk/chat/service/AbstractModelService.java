package com.melnyk.chat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractModelService<T, ID>{

    public abstract JpaRepository<T, ID> getRepository();

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    public Optional<T> findById(ID aLong) {
        return getRepository().findById(aLong);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public List<T> findAllById(Iterable<ID> longs) {
        return getRepository().findAllById(longs);
    }

    public void deleteById(ID aLong) {
        getRepository().deleteById(aLong);
    }

    public long count() {
        return getRepository().count();
    }

    public <S extends T> S save(S entity){
        return getRepository().save(entity);
    }

}
