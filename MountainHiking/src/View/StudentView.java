/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MountainController;
import Controller.StudentController;
import Model.Student;
import Utils.Acceptable;
import Utils.Inputter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mp
 */
public class StudentView {

    private static final Scanner sc = new Scanner(System.in);
    private final StudentController studentController;

    public StudentView(StudentController studentController) {
        this.studentController = studentController;
    }

    //Function 1: Register Customer
    public void registerStudent() {
        String id = Inputter.getString(
                "Enter student ID (SE/HE/DE/QE/CE followed by 6 digits): ",
                "Invalid code format. Must start with SE, HE, DE, QE, CE followed by 6 digits",
                Acceptable.STU_ID_VALID
        );

        try {
            if (studentController.isStudentExist(id)) {
                System.out.println("Error: Student id already exist");
                return;
            }

            String name = Inputter.getString(
                    "Enter student name (2-20 characters): ",
                    "Name must be between 2 and 20 characters",
                    Acceptable.NAME_VALID
            );

            String phone = Inputter.getString(
                    "Enter phone number: (10 digits): ",
                    "Invalid phone number format",
                    Acceptable.PHONE_VALID
            );

            String email = Inputter.getString(
                    "Enter email: ",
                    "Invalid email format",
                    Acceptable.EMAIL_VALID
            );

//            String mountainCode = Inputter.getString(
//                    "Enter mountainCode: ",
//                    "Invalid mountain code",
//                    "^(1[0-3]|[1-9])$"
//            );
            String mountainCode = Inputter.getMountainCode(
                    "Enter mountain code: ",
                    "Invalid mountain code"
            );

            studentController.registerStudent(id, name, phone, email, mountainCode);
            System.out.println("Student registered succesfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateRegistration() {
        do {
            String id = Inputter.getString(
                    "Enter student ID (SE/HE/DE/QE/CE followed by 6 digits): ",
                    "Invalid code format. Must start with SE, HE, DE, QE, CE followed by 6 digits",
                    Acceptable.STU_ID_VALID
            );

            try {
                if (!studentController.isStudentExist(id)) {
                    System.out.println("This student is not exist");
                    continue;
                }

                System.out.println("Your current information: ");
                System.out.println(studentController.findStudentById(id));
                System.out.println("\nLeave blank to keep current value");

                String name = Inputter.getString(
                        "Enter student name (2-20 characters): ",
                        "Name must be between 2 and 20 characters",
                        "^$|^[\\p{L}\\s]{2,20}$"
                );

                String phone = Inputter.getString("Enter phone number (10 digits): ",
                        "Invalid phone number format",
                        "^$|^0\\d{9}$"
                );

                String email = Inputter.getString(
                        "Enter email: ",
                        "Invalid email format",
                        "^$|^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
                );

//                String mountainCode = Inputter.getString(
//                        "Enter mountainCode: ",
//                        "Invalid mountain code",
//                        "^$|^(1[0-3]|[1-9])$"
//                );
                String mountainCode = Inputter.updateMountainCode(
                        "Enter mountain code: ",
                        "Invalid mountain code"
                );

                studentController.updateRegistration(id,
                        name.isEmpty() ? null : name,
                        phone.isEmpty() ? null : phone,
                        email.isEmpty() ? null : email,
                        mountainCode.isEmpty() ? null : mountainCode);
                System.out.println("Student updated successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            String answer = Inputter.getString(
                    "\nDo you want to update another student? (Y/N) or (Yes/No): ",
                    "Invalid choice",
                    "(?i)^(?:y(?:es)?|no?)$"
            );

            if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("yes")) {
                System.out.println("Student updated successfully!");
                break;
            }
        } while (true);
    }

    public void displayRegistered() {
        List<Student> students = studentController.getAllStudent();
        if (students.isEmpty()) {
            System.out.println("No students have registered yet");
            return;
        }

        System.out.println("Student information: ");
        displayStudent(students);
    }

    public void deleteRegistered() {
        String id = Inputter.getString(
                "Enter student ID (SE/HE/DE/QE/CE followed by 6 digits): ",
                "Invalid code format. Must start with SE, HE, DE, QE, CE followed by 6 digits",
                Acceptable.STU_ID_VALID
        );

        studentController.deleteRegistration(id);
    }

    public void searchRegistered() {
        System.out.print("Enter search name: ");
        String searchName = sc.nextLine().trim();
        List<Student> result = studentController.searchRegistrationByName(searchName);
        if (result.isEmpty()) {
            System.out.println("No one matches the search criteria!");
        } else {
            System.out.println("\nMatching students: ");
            displayStudent(result);
        }
    }

    public void filterByCampus() {
//        System.out.println("Enter campus (SE/HE/DE/QE/CE): ");
//        String campus = sc.nextLine().trim();
        String campus = Inputter.getString(
                "Enter campus (SE/HE/DE/QE/CE): ",
                "Invalid campus format. Must start with SE, HE, DE, QE, CE",
                "^[CcDdHhSsQq][Ee]"
        );
        List<Student> result = studentController.filterByCampus(campus);
        if (result.isEmpty()) {
            System.out.println("No students have registered under this campus");
        } else {
            System.out.println("\nMatching students: ");
            displayStudent(result);
        }
    }

    private void displayStudent(List<Student> students) {
        /*----------------------------------------------------------------
        Student ID | Name | Phone | Peak Code| Fee
        ----------------------------------------------------------------
        SE123456 | John Doe | 0987654321 | MT01 | 3,900,000
        HE654321 | Jane Smith | 0902345678 | MT05 | 6,000,000
        ----------------------------------------------------------------*/

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Student ID | Name            | Phone      | Peak Code | Fee      ");
        System.out.println("-----------------------------------------------------------------");
        for (Student s : students) {
            String formattedFee = String.format("%,.0f", s.getTuitionFee());
            System.out.printf("%-10s | %-15s | %-10s | %-9s | %9s\n",
                    s.getId().toUpperCase(),
                    Inputter.capitalizeFirstLetter(s.getName()),
                    s.getPhone(),
                    "MT" + s.getMountainCode(),
                    formattedFee);
        }
        System.out.println("-----------------------------------------------------------------");
    }


}
