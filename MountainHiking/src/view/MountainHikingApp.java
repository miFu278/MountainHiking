package view;

import utils.Inputter;
import controller.Students;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class MountainHikingApp {

    public static void main(String[] args) {
        Students x = new Students();

        int choice = 0;
        do {
            displayMenu();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    if(Students.isSaved() == false){
                        String tmp = Inputter.getString("Do you want to save the changes before exiting (Y/N)");
                        if(tmp.equalsIgnoreCase("y")){
                            
                        }
                        else {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("This function is not available");
            }

        } while (choice != 9);

    }

    private static void displayMenu() {
        System.out.println("1. New Registration: \n"
                + "2. Update Registration Information: \n"
                + "3. Display Registered List: \n"
                + "4. Delete Registration Information: \n"
                + "5. Search Participants by Name: \n"
                + "6. Filter Data by Campus: \n"
                + "7. Statistics of Registration Numbers by Location: \n"
                + "8. Save Data to File: \n"
                + "9. Exit the Program: ");
    }
}
