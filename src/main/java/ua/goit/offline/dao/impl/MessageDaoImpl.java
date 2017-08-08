package ua.goit.offline.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.offline.dao.AbstractGenericDaoImpl;
import ua.goit.offline.dao.MessageDao;
import ua.goit.offline.entity.Messages;

/**
 * Created by User on 08.08.2017.
 */
@Repository //так помечаю все имплементации dao, которые работают с бд
public class MessageDaoImpl extends AbstractGenericDaoImpl<Long, Messages> implements MessageDao {

    @Autowired //говорю Spring, чтобы искал бин типа имплементация SessionFactory (в данном случае это будет  LocalSessionFactoryBean в ModelConfiguration.java)
    public MessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
