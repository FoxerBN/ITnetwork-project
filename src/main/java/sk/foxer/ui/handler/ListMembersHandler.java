package sk.foxer.ui.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;
import sk.foxer.model.User;
import sk.foxer.service.UserService;
import sk.foxer.util.ColorConsole;
import sk.foxer.util.InputUtil;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class ListMembersHandler implements MenuHandler {
    private final UserService userService;
    private final InputUtil inputUtil;

    @Override
    public void handle() {
        List<User> users = userService.getAllUsers();
        System.out.println("=== List of all members ===");

        if (users.isEmpty()) {
            System.out.println("No members found.");
        } else {
            System.out.println("\n".repeat(50));
            for (User user : users) {
                System.out.println("=".repeat(35));
                System.out.println(ColorConsole.PURPLE + "ID: " + ColorConsole.YELLOW + user.getId() + ColorConsole.RESET);
                System.out.println(ColorConsole.PURPLE + "Name: " + ColorConsole.YELLOW + user.getUsername() + " " + user.getSurname() + ColorConsole.RESET);
                System.out.println(ColorConsole.PURPLE + "Age: " + ColorConsole.YELLOW + user.getAge() + ColorConsole.RESET);
                System.out.println(ColorConsole.PURPLE + "Telephone: " + ColorConsole.YELLOW + user.getTelephone() + ColorConsole.RESET);
                System.out.println(ColorConsole.PURPLE + "Created At: " + ColorConsole.YELLOW + user.getCreatedAt() + ColorConsole.RESET);
                System.out.println("=".repeat(35));
                System.out.println();
            }
            inputUtil.continuePrompt();
            System.out.println("\n".repeat(50));

        }
    }


}
