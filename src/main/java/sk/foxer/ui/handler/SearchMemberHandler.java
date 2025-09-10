package sk.foxer.ui.handler;

import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;

@Component
public class SearchMemberHandler  implements MenuHandler {



    @Override
    public void handle() {
        System.out.println("Searching for a member...");
        // Implementation for searching a member goes here
        // use Input util and then call user service and send data
    }
}
