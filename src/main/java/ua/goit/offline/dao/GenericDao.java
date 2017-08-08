package ua.goit.offline.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by studentgoit on 07.08.17.
 */
public interface GenericDao<K extends Serializable, V> {

    V getById(K id, Class<? extends V> idClass);

    List<V> getAll(Class<? extends V> entityClass);

    void save(V entity);

    void update(V entity);

    void remove(V entity);
}
