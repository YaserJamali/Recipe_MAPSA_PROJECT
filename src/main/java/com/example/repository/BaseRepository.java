package com.example.repository;

public abstract class BaseRepository<T> {

    public abstract T save(T t);

    public abstract T update(T t);

    public abstract T findById(Long id);

    public abstract T deleteById(Long id);
}
