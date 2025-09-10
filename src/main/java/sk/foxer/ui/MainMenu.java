package sk.foxer.ui;

import org.springframework.stereotype.Component;
import sk.foxer.util.InputUtil;

@Component
public class MainMenu {
    private final InputUtil inputUtil;

    public MainMenu(InputUtil inputUtil) {
        this.inputUtil = inputUtil;
    }


    public void displayLogo() {
        System.out.println("""
                
                
                
                
                
                
                
                
                ===============================================================
                 ██████╗ ███████╗███╗   ██╗███████╗██████╗  █████╗ ██╗     ██╗
                ██╔════╝ ██╔════╝████╗  ██║██╔════╝██╔══██╗██╔══██╗██║     ██║
                ██║  ███╗█████╗  ██╔██╗ ██║█████╗  ██████╔╝███████║██║     ██║
                ██║   ██║██╔══╝  ██║╚██╗██║██╔══╝  ██╔══██╗██╔══██║██║     ██║
                ╚██████╔╝███████╗██║ ╚████║███████╗██║  ██║██║  ██║███████╗██║
                 ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝
                ===============================================================
                """);
    }

    public void displayMenu() {
        System.out.println("""
                ╔═════════════════════════╗
                ║        MAIN MENU        ║
                ╚═════════════════════════╝
                1. Add member
                2. List members
                3. Search member
                4. Delete member
                5. Exit
                ─────────────────────────
                Choose an option: 
                """);
    }

    public void optionsHandler() {
        boolean running = true;

        while (running) {
            displayLogo();
            displayMenu();

            int choice = inputUtil.choseOption();

            switch (choice) {
                case 1 -> System.out.println("add memberrrr");
                case 2 -> System.out.println("list memberrrr");
                case 3 -> System.out.println("serach memberrrr");
                case 4 -> System.out.println("delete memberrrr");
                case 5 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
