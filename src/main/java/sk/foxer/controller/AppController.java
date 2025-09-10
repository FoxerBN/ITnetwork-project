package sk.foxer.controller;

import org.springframework.stereotype.Component;
import sk.foxer.service.UserService;
import sk.foxer.ui.MainMenu;

@Component
public class AppController {
    private final MainMenu mainMenu;
    private final UserService userService;

    public AppController(MainMenu mainMenu, UserService userService) {
        this.userService = userService;
        this.mainMenu = mainMenu;
    }

    public void start() {
        while (true) {
            mainMenu.displayLogo();
            mainMenu.displayMenu();
            mainMenu.optionsHandler();
            break;
        }
    }
}
