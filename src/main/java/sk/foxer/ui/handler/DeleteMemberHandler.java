package sk.foxer.ui.handler;

import org.springframework.stereotype.Component;
import sk.foxer.controller.MenuHandler;


@Component
public class DeleteMemberHandler implements MenuHandler {


    @Override
    public void handle() {
        System.out.println("Deleting a member...");
        // Implementation for deleting a member goes here
        // use Input util and then call user service and send data
    }
}
