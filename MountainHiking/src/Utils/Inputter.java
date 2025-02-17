/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Scanner;
import Controller.MountainController;

/**
 *
 * @author mp
 */
public class Inputter {

    private final static Scanner sc = new Scanner(System.in);

    public static String getString(String prompt, String error, String regex) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("Error: " + error);
        } while (true);
    }

    public static int getInt(String prompt, String error, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Error: " + error + " (Must be between " + min + " and " + max + ")");
            } catch (NumberFormatException e) {
                System.out.println("Error: " + error + " (Must be a valid number)");
            }
        }
    }

    public static String getMountainCode(String prompt, String error) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (MountainController.isValidMountainCode(input)) {
                return input;
            }
            System.out.println("Error: " + error);
        } while (true);
    }

    public static String updateMountainCode(String prompt, String error) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (MountainController.isValidMountainCode(input) || input.isEmpty()) {
                return input;
            }
            System.out.println("Error: " + error);
        } while (true);
    }

}
