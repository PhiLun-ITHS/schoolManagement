package menu;

import mainAndInput.Main;
import mainAndInput.input;

public class courseMenu {

    public static void courseMenu(){

        System.out.println("1. Add Course");
        System.out.println("2. Update Course");
        System.out.println("3. Delete Course");
        System.out.println("6. Return");
        System.out.println("0. Exit");

        System.out.print("choice: ");
        Integer choice = input.inputInt();
        switch(choice){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 6:
                return;
            case 0:
                Main.alive = false;
                break;
            default:
                System.out.println("Invalid choice: (" + choice + ") try again!");
                courseMenu();
                break;
        }
    }
}
