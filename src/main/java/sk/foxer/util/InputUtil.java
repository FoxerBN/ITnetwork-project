package sk.foxer.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputUtil {
    private final Scanner scanner;

    public InputUtil() {
        this.scanner = new Scanner(System.in);
    }

    public String insertName(){
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public String insertSurename(){
        System.out.print("Enter your surename: ");
        return scanner.nextLine();
    }

    public Integer insertAge(){
        System.out.print("Enter your age: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTelephone(){
        System.out.print("Enter your telephone: ");
        return scanner.nextLine();
    }

    public int choseOption(){
        System.out.print("Choose an option: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
