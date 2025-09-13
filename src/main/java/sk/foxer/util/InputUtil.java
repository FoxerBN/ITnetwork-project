package sk.foxer.util;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sk.foxer.model.User;
import sk.foxer.service.UserService;

import java.util.Scanner;

@Component
public class InputUtil {
    private final Scanner scanner;
    private final UserService userService;

    public InputUtil(UserService userService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
    }

    public String insertName() {
        return getValidatedString("Enter your name: ", "Name", 2);
    }

    public String insertSurname() {
        return getValidatedString("Enter your surname: ", "Surname", 2);
    }

    public String insertTelephone() {
        return getValidatedString("Enter your telephone: ", "Telephone", 9);
    }

    public Integer insertAge() {
        int age;
        do {
            System.out.print("Enter your age: ");
            String input = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(input);
                if (age < 1 || age > 150) {
                    System.out.println("Age must be between 1 and 150. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number. Please try again.");
            }
        } while (true);
        return age;
    }

    public int choseOption() {
        int option;
        do {
            System.out.print("Choose an option: ");
            try {
                option = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number. Please try again.");
            }
        } while (true);
        return option;
    }

    private String getValidatedString(String prompt, String fieldName, int minLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty. Please try again.");
                continue;
            }
            if (input.length() < minLength) {
                System.out.println(fieldName + " must be at least " + minLength + " characters long. Please try again.");
                continue;
            }
            break;
        } while (true);
        return input;
    }

    public void continuePrompt() {
        System.out.print(ColorConsole.WHITE + "Press Enter to continue..." + ColorConsole.RESET);
        try {
            do {
                System.in.read();
            } while (System.in.available() > 0);
        } catch (Exception e) {
            scanner.nextLine();
        }
    }

    public long removeUserId() {
        System.out.print(ColorConsole.CYAN + "Enter user ID: " + ColorConsole.RESET);
        try {
            String input = scanner.nextLine().trim();
            long userId = Long.parseLong(input);
            if (userId < 1) {
                System.out.println(ColorConsole.RED + "Please enter a valid ID (must be greater than 0)." + ColorConsole.RESET);
                return removeUserId();
            }
            User user = userService.getUserById(userId);
            if (user == null) {
                System.out.println(ColorConsole.RED + "No member found with ID " + userId + ". Please try again." + ColorConsole.RESET);
                return removeUserId();
            }
            return userId;
        } catch (NumberFormatException e) {
            System.out.println(ColorConsole.RED + "Please enter a valid number." + ColorConsole.RESET);
            return removeUserId();
        }
    }
}