package sk.foxer.ui.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;
import sk.foxer.model.User;
import sk.foxer.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class ListMembersHandler implements MenuHandler {
    private final UserService userService;


    @Override
    public void handle() {
        List<User> users = userService.getAllUsers();
        System.out.println("=== List of all members ===");

        if (users.isEmpty()) {
            System.out.println("No members found.");
        } else {
            for (User user : users) {
                System.out.println("=".repeat(100));
                System.out.println("ID: " + user.getId() + ", Name: " + user.getUsername() + " " + user.getSurname() +
                        ", Age: " + user.getAge() + ", Telephone: " + user.getTelephone() +
                        ", Created At: " + user.getCreatedAt()+ "||");
                System.out.println("=".repeat(100));
            }
        }
    }


}
