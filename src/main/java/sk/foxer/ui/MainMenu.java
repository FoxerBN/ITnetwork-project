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
                 ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝ the best insurance company
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
                """);
    }

    public void space( ) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
