package ua.nure.teteruk.dao;

import java.util.List;

public interface GenericDAO<T> {

    T create (T entity);

    T get(int id);

    List<T> getAll();

    void update(T entity);

    boolean delete(T entity);
}
