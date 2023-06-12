package com.example.service;

import java.util.List;

public abstract class BaseService<T, S> {

    public abstract void save(T t);


    public abstract void update(T t);

    public abstract S delete(Long id);

    public abstract S findById(Long id);

    public abstract List<T> findAll(T t);

    public abstract List<T> findByExample(S s);

    public abstract List<T> getAll();

}
