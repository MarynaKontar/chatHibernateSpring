package ua.goit.offline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.dao.UserDao;
import org.springframework.stereotype.Service;
import ua.goit.offline.entity.User;

import java.util.List;

/**
 * Created by studentgoit on 07.08.17.
 */
@Service //в service можно использовать много dao, если в одной транзакции надо созранять в разные таблицы, использовать логику
public class UserService {

    @Autowired //говорю Spring, чтобы искал бин типа имплементация UserDao (в данном случае это будет UserDaoImpl.java)
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true) //прописываем readOnly = true, чтобы не создавал заново сессию.
    // Если даже захотим в таком методе изменитьданные в бд - выкинет exception. readOnly оптимизируется бд -
    // выше производительность ( MySQL для InnoDB только в 5.6.4 версии.).
    // Если без readOnly = true, то Hibernate транзакцию откроет, но коммитить ее уже будет некому и что произойдет
    // когда соединение вернется в пул с незакомиченой транзакцией спецификация не оглашает. MySQL ее вроде откатывает,
    // а вот Oracle ее почему-то коммитит.
    public User getById(String id) {
        return userDao.getById(id, User.class);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll(User.class);
    }

    @Transactional
    public void save(User entity) {
        userDao.save(entity);
    }

    @Transactional
    public void update(User entity) {
        userDao.update(entity);
    }

    @Transactional
    public void remove(User entity) {
        userDao.remove(entity);
    }
}
