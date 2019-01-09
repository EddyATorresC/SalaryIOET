package UI;
import Classes.*;
import Logic.EntityLogic;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner =  new Scanner(System.in);
        int exit = 0;
        do {
        System.out.println("*****Welcome*****");
        System.out.println("Choose one option: ");
        System.out.println("1. Check total to pay. \n2. Check previous payment by name. \n0. Salir.");
        String option = scanner.nextLine();

            switch (option) {
                case "0": {
                    exit = 1;
                }
                break;
                case "1": {
                    System.out.println("Please enter the name and schedule in this format: NAME=DDhh:mm,...,DDhh:mm");
                    String input = scanner.nextLine();
                    Entity entity = new Entity(input);
                    EntityLogic entityLogic = new EntityLogic();
                    entityLogic.calculateSalary(entity.getChainOfCharacters());
                }
                break;
                case "2": {
                    System.out.print("Please enter the name to ask for: ");
                    String name = scanner.nextLine();
                    Entity entity = new Entity(name);
                    EntityLogic entityLogic = new EntityLogic();
                    entityLogic.search(entity.getChainOfCharacters());
                }
                break;
                default: {
                    System.out.println("That is not a possible option.");
                }
                break;
            }
        }while (exit!=1);
    }

}
