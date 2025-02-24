/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Utils.Inputter;
import View.MenuView;
import View.StudentView;

/**
 *
 * @author mp
 */
public class MenuController {

    //Initialize view
    private final MenuView menuView;
    private final StudentView studentView;
    
    //Initialize controller
    private final StudentController studentController;

//    private final StatisticController statisticController;
//    private final FileHandler fileHandler;
    public MenuController() {
        this.studentController = new StudentController();
        this.menuView = new MenuView(this);
        this.studentView = new StudentView(studentController);
    }

    public void start() {
        while (true) {
            menuView.displayMenu();
            int choice = menuView.getUserChoice();
            processUserChoice(choice);
        }
    }

    private void processUserChoice(int choice) {
        if (choice < 1 || choice > 9) {
            System.out.println("\nInvalid choice! Please select number between 1 and 9.");
            return;
        }

        if (choice == 9) {
            if (!studentController.isSaved()) {
                String answer = Inputter.getString(
                        "Do you want to save the changes before exiting? (Y/N): ",
                        "Invalid choice! Please enter Y/N",
                        "(?i)^(?:y(?:es)?|no?)$"
                );
                if (answer.equalsIgnoreCase("y")) {
                    studentController.saveStudents();
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }

        try {
            switch (choice) {
                case 1:
                    studentView.registerStudent();
                    break;
                case 2:
                    studentView.updateRegistration();
                    break;
                case 3:
                    studentView.displayRegistered();
                    break;
                case 4:
                    studentView.deleteRegistered();
                    break;
                case 5:
                    studentView.searchRegistered();
                    break;
                case 6:
                    studentView.filterByCampus();
                    break;
                case 7:
                    studentController.statisticRegister();
                    break;
                case 8:
                    studentController.saveStudents();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erorr: " + e.getMessage());
        }
    }
}
