package ua.goit.offline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.dao.ChatDao;
import ua.goit.offline.entity.Chat;

import java.util.List;

/**
 * Created by User on 08.08.2017.
 */
@Service
public class ChatService {

    @Autowired
    private ChatDao chatDao;

    public ChatService(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Transactional(readOnly = true)
    public Chat getById(String id) {
        return chatDao.getById(id, Chat.class);
    }

    @Transactional(readOnly = true)
    public List<Chat> getAll() {
        return chatDao.getAll(Chat.class);
    }

    @Transactional
    public void save(Chat entity) {
        chatDao.save(entity);
    }

    @Transactional
    public void update(Chat entity) {
        chatDao.update(entity);
    }

    @Transactional
    public void remove(Chat entity) {
        chatDao.remove(entity);
    }
}
