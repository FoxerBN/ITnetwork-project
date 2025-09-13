package sk.foxer.util;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class InputUtil {
    private final Scanner scanner;

    public InputUtil() {this.scanner = new Scanner(System.in);}

    public String insertName(){return getValidatedString("Enter your name: ", "Name", 2);}
    public String insertSurename(){return getValidatedString("Enter your surname: ", "Surname", 2);}
    public String insertTelephone(){return getValidatedString("Enter your telephone: ", "Telephone", 10);}

    public Integer insertAge(){
        Integer age;
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

    public int choseOption(){
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
}