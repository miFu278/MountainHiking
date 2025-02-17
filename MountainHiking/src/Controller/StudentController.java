/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FileHandler;
import Model.Student;
import Utils.Inputter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mp
 */
public class StudentController {

    private final List<Student> students;
    private boolean isSaved;

    public boolean isIsSaved() {
        return isSaved;
    }

    public StudentController() {
        students = FileHandler.loadRegistration();
        this.isSaved = true;
    }

    // Function 1: New Registration
    public void registerStudent(String id, String name, String phone, String email, String mountainCode)
            throws IllegalArgumentException {
        if (findStudentById(id) != null) {
            throw new IllegalArgumentException("Student code already exist");
        }
        Student student = new Student(id, name, phone, email, mountainCode);
        students.add(student);
        isSaved = false;
    }

    // Function 2: Update registartion information
    public void updateRegistration(String id, String name, String phone, String email, String mountainCode)
            throws IllegalArgumentException {
        Student student = findStudentById(id);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        if (name != null && !name.trim().isEmpty()) {
            student.setName(name);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            student.setPhone(phone);
            student.setTuitionFee(student.calcTuitionFee());
        }
        if (email != null && !email.trim().isEmpty()) {
            student.setEmail(email);
        }
        if (mountainCode != null && !mountainCode.trim().isEmpty()) {
            student.setMountainCode(mountainCode);
        }
        isSaved = false;
    }

    // Function 3: Display registered list
    // Function 4: Delete Registration Information
    public void deleteRegistration(String id) throws IllegalArgumentException {
        Student student = findStudentById(id);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        System.out.println(student);
        String tmp = Inputter.getString(
                "Are you sure you want to delete this register (Y/N) or (Yes/No): ",
                "Invalid choice (Y/N) or (Yes/No)",
                "(?i)^(?:y(?:es)?|no?)$"
        );
        if (tmp.equalsIgnoreCase("n") || tmp.equalsIgnoreCase("no")) {
            return;
        }
        students.remove(student);
        isSaved = false;
    }

    // Function 5: Search participants by name
    public List<Student> searchRegistrationByName(String searchName) {
        if (searchName == null || searchName.trim().isEmpty()) {
            return new ArrayList<>();
        }
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(searchName.toLowerCase())) {
                result.add(s);
            }
        }
        Collections.sort(result, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return result;
    }

    // Function 6: Filter data by campus
    public List<Student> filterByCampus(String campusCode) {
        if (campusCode == null || campusCode.trim().isEmpty()) {
            return new ArrayList<>();
        }
        List<Student> result = new ArrayList<>();
        String searchCode = campusCode.toLowerCase();
        for (Student s : students) {
            if (s.getId().toLowerCase().contains(searchCode)) {
                result.add(s);
            }
        }
        Collections.sort(result, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return result;
    }

    // Function 7: Statistic Info
    public void statisticRegister() {
        StatisticController statisticController = new StatisticController(students);
        statisticController.displayStatistic();
    }

    //Get first element
    public Student getLast() {
        List<Student> sortedList = getAllStudent();
        return sortedList.get(students.size() - 1);
    }

    // Helper class
    private Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public List<Student> getAllStudent() {
        List<Student> sortedStudent = new ArrayList<>(students);
        Collections.sort(sortedStudent, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return sortedStudent;
    }

    public void saveStudents() {
        try {
            FileHandler.saveRegistration(students);
            this.isSaved = true;
        } catch (IOException e) {
            System.out.println("Error saving register: " + e.getMessage());
        }
    }

    public boolean isStudentExist(String id) {
        return findStudentById(id) != null;
    }

}
