package mate.academy.jpademo.dao;

import mate.academy.jpademo.model.Lector;

import java.util.List;

public interface LectorDao extends CrudDao<Lector, Integer> {
    List<Lector> findAll();
}
