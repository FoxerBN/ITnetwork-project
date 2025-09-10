package sk.foxer.controller;

import org.springframework.stereotype.Component;
import sk.foxer.service.UserService;
import sk.foxer.ui.MainMenu;
import sk.foxer.ui.handler.AddMemberHandler;
import sk.foxer.ui.handler.DeleteMemberHandler;
import sk.foxer.ui.handler.ListMembersHandler;
import sk.foxer.ui.handler.SearchMemberHandler;
import sk.foxer.util.InputUtil;

import java.util.Map;

@Component
public class AppController {
    private final MainMenu mainMenu;
    private final InputUtil inputUtil;
    private final Map<Integer, MenuHandler> handlers;

    public AppController(MainMenu mainMenu, InputUtil inputUtil,
                         AddMemberHandler addHandler,
                         ListMembersHandler listHandler,
                         SearchMemberHandler searchHandler,
                         DeleteMemberHandler deleteHandler) {
        this.mainMenu = mainMenu;
        this.inputUtil = inputUtil;
        this.handlers = Map.of(
                1, addHandler,
                2, listHandler,
                3, searchHandler,
                4, deleteHandler
        );
    }

    public void start() {
        mainMenu.displayLogo();
        mainMenu.displayMenu();
        while (true) {

            int choice = inputUtil.choseOption();

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            MenuHandler handler = handlers.get(choice);
            if (handler != null) {
                handler.handle();
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}