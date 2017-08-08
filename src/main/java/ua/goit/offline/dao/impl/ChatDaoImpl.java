package ua.goit.offline.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.offline.entity.Chat;
import ua.goit.offline.dao.AbstractGenericDaoImpl;
import ua.goit.offline.dao.ChatDao;

/**
 * Created by studentgoit on 07.08.17.
 */
@Repository //так помечаю все имплементации dao, которые работают с бд
public class ChatDaoImpl extends AbstractGenericDaoImpl<String, Chat> implements ChatDao {

    @Autowired //говорю Spring, чтобы искал бин типа имплементация SessionFactory (в данном случае это будет  LocalSessionFactoryBean в ModelConfiguration.java)
    public ChatDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
