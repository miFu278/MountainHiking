/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MenuController;
import java.util.Scanner;

/**
 *
 * @author mp
 */
public class MenuView {

    private static final Scanner sc = new Scanner(System.in);
    private final MenuController menuController;

    public MenuView(MenuController menuController) {
        this.menuController = menuController;
    }

    public void displayMenu() {
        System.out.println("\n=== Mountain Hiking Registration System ===");
        System.out.println("1. New Registration: \n"
                + "2. Update Registration Information: \n"
                + "3. Display Registered List: \n"
                + "4. Delete Registration Information: \n"
                + "5. Search Participants by Name: \n"
                + "6. Filter Data by Campus: \n"
                + "7. Statistics of Registration Numbers by Location: \n"
                + "8. Save Data to File: \n"
                + "9. Exit the Program: ");
        System.out.print("Enter your choice: ");
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
