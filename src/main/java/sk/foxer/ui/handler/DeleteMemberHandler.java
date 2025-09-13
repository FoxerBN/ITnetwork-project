package sk.foxer.ui.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;
import sk.foxer.model.User;
import sk.foxer.service.UserService;
import sk.foxer.util.ColorConsole;
import sk.foxer.util.InputUtil;

import java.util.List;


@Component
@AllArgsConstructor
public class DeleteMemberHandler implements MenuHandler {
    private final UserService userService;
    private final InputUtil inputUtil;

    @Override
    public void handle() {
        List<User> users = userService.getAllUsers();
        System.out.println("\n".repeat(50));
        System.out.println(ColorConsole.YELLOW + "===============================================" + ColorConsole.RESET);
        System.out.println(ColorConsole.WHITE + "Which member do you want to delete?" + ColorConsole.RESET);
        System.out.println(ColorConsole.YELLOW + "===============================================" + ColorConsole.RESET);

        for (User user : users) {
            System.out.println(ColorConsole.BLUE + "ID: " + user.getId() + ColorConsole.RESET +
                    " - " + ColorConsole.GREEN + "Name: " + user.getUsername() + " " + user.getSurname() + ColorConsole.RESET);
        }
        System.out.println(ColorConsole.YELLOW + "===============================================" + ColorConsole.RESET);

        long idToDelete = inputUtil.removeUserId();
        userService.deleteUserById(idToDelete);
        System.out.println("\n".repeat(50));
        System.out.println(ColorConsole.GREEN + "Member with ID " + idToDelete + " has been deleted." + ColorConsole.RESET);
        inputUtil.continuePrompt();
        System.out.println("\n".repeat(50));
    }
}
