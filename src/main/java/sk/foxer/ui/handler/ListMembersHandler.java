package sk.foxer.ui.handler;

import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;


@Component
public class ListMembersHandler  implements MenuHandler {



    @Override
    public void handle() {
        System.out.println("Listing all members...");
        // Implementation for listing all members goes here
        // use Input util and then call user service and send data
    }
}
