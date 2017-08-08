package ua.goit.offline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.dao.MessageDao;
import ua.goit.offline.entity.Messages;

import java.util.List;

/**
 * Created by User on 08.08.2017.
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Transactional(readOnly = true)
    public Messages getById(Long id) {
        return messageDao.getById(id, Messages.class);
    }

    @Transactional(readOnly = true)
    public List<Messages> getAll() {
        return messageDao.getAll(Messages.class);
    }

    @Transactional
    public void save(Messages entity) {
        messageDao.save(entity);
    }

    @Transactional
    public void update(Messages entity) {
        messageDao.update(entity);
    }

    @Transactional
    public void remove(Messages entity) {
        messageDao.remove(entity);
    }
}
