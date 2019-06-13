package mate.academy.jpademo.dao;

public interface CrudDao<T, ID> {
    T read(ID id);

    ID create(T t);

    void update(T t);

    void delete(T t);
}