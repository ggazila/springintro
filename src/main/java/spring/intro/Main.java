package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.models.User;
import spring.intro.services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user1 = new User();
        user1.setLogin("first");
        user1.setPassword("a");
        userService.add(user1);
        User user2 = new User();
        user2.setLogin("second");
        user2.setPassword("b");
        userService.add(user2);
        System.out.println(userService.listUsers());
    }
}
