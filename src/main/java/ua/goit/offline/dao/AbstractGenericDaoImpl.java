package ua.goit.offline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by studentgoit on 07.08.17.
 */
public abstract class AbstractGenericDaoImpl<K extends Serializable, V> implements GenericDao<K, V> {

    private SessionFactory sessionFactory;

    public AbstractGenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public V getById(K id, Class<? extends V> idClass) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(idClass, id);
    }

    @Override
    public List<V> getAll(Class<? extends V> entityClass) {
        Session session = sessionFactory.getCurrentSession();
        return (List<V>) session.createCriteria(entityClass).list();
    }

    @Override
    public void save(V entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public void update(V entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void remove(V entity) {
        Session session = sessionFactory.getCurrentSession();
        try{session.remove(entity);}
        catch (Exception e) {throw new RuntimeException(e);}
    }
}
