package sk.foxer.ui.handler;

import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;



@Component
public class AddMemberHandler  implements MenuHandler {



    @Override
    public void handle() {
        System.out.println("Adding a new member...");
        // Implementation for adding a new member goes here
        // use Input util and then call user service and send data
    }
}
