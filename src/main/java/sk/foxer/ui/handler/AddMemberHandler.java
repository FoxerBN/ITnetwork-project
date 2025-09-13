package sk.foxer.ui.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;
import sk.foxer.model.User;
import sk.foxer.service.UserService;
import sk.foxer.util.ColorConsole;
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
        user.setSurname(inputUtil.insertSurname());
        user.setAge(inputUtil.insertAge());
        user.setTelephone(inputUtil.insertTelephone());

        User savedUser = userService.createUser(user);

        System.out.println("\n".repeat(50));

        System.out.println(ColorConsole.GREEN + "=== New member created ===" + ColorConsole.RESET);
        System.out.println(ColorConsole.PURPLE + "Name: " + ColorConsole.YELLOW + savedUser.getUsername() + ColorConsole.RESET);
        System.out.println(ColorConsole.PURPLE + "Surname: " + ColorConsole.YELLOW + savedUser.getSurname() + ColorConsole.RESET);
        System.out.println(ColorConsole.PURPLE + "Age: " + ColorConsole.YELLOW + savedUser.getAge() + ColorConsole.RESET);
        System.out.println(ColorConsole.PURPLE + "Telephone: " + ColorConsole.YELLOW + savedUser.getTelephone() + ColorConsole.RESET);
        System.out.println(ColorConsole.GREEN + "========================" + ColorConsole.RESET);

        inputUtil.continuePrompt();
        System.out.println("\n".repeat(50));
    }
}