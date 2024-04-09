package app;

import java.util.Scanner;

public class InputHandle {


    static Scanner scan = new Scanner(System.in);
    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        return scan.nextLine();
    }

    public static int getIntInput(String prompt){
        System.out.println(prompt);
        int input = scan.nextInt();
        scan.nextLine();
        return input;


    }

}
