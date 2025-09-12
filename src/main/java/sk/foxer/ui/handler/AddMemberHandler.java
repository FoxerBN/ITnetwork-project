package sk.foxer.ui.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;
import sk.foxer.model.User;
import sk.foxer.service.UserService;
import sk.foxer.util.InputUtil;

@Component
@AllArgsConstructor
public class AddMemberHandler  implements MenuHandler {
    private final InputUtil inputUtil;
    private final UserService userService;

    @Override
    public void handle() {
        System.out.println("--- Let's create new member ---");
        User user = new User();
        user.setUsername(inputUtil.insertName());
        user.setSurname(inputUtil.insertSurename());
        user.setAge(inputUtil.insertAge());
        user.setTelephone(inputUtil.insertTelephone());

        User savedUser = userService.createUser(user);

        System.out.println("New member created: " + savedUser.getUsername() + " " + savedUser.getSurname() +
                ", age: " + savedUser.getAge() + ", telephone: " + savedUser.getTelephone());
    }
}