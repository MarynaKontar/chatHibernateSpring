package ua.goit.offline;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.goit.offline.configuration.ModelConfiguration;
import ua.goit.offline.entity.Chat;
import ua.goit.offline.entity.Messages;
import ua.goit.offline.entity.User;
import ua.goit.offline.service.ChatService;
import ua.goit.offline.service.MessageService;
import ua.goit.offline.service.UserService;

/**
 * Created by studentgoit on 07.08.17.
 */

public class TestCharApplication {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ModelConfiguration.class)) {

            UserService userService = context.getBean(UserService.class);
            ChatService chatService = context.getBean(ChatService.class);
            MessageService messageService = context.getBean(MessageService.class);


//            User user = userService.getById("test");
//            if (user == null) {
//                user = new User();
//                user.setLogin("test");
//                user.setPassword("test");
//                user.setUsername("test");
//                userService.save(user);
//            }
//            userService.getAll().forEach(System.out::println);
//            userService.remove(user);
//            System.out.println("--------------------");
//            userService.getAll().forEach(System.out::println);

//            Chat chat = chatService.getById("public");
//            if (chat == null) {
//                chat = new Chat();
//                chat.setName("public");
//                chat.setDescription("This is public chat");
//                chatService.save(chat);
//            }
//            chatService.getAll().forEach(System.out::println);
//            chatService.remove(chat);
//            System.out.println("----------------------");
//            chatService.getAll().forEach(System.out::println);


//            Messages message = messageService.getById(1L);
//            if (message == null) {
//                message = new  Messages();
//                message.setChat(chat);
//                message.setUser(user);
//                message.setText("This is first message");
//                messageService.save(message);
//            }
//            messageService.getAll().forEach(System.out::println);
//            messageService.remove(message);
//            System.out.println("----------------------");
//            messageService.getAll().forEach(System.out::println);

//            User user1 = new User();
//            user1.setLogin("testUpdated");
//            user1.setPassword("testUpdated");
//            user1.setUsername("test");
//            userService.update(user1);

        }
    }
}
