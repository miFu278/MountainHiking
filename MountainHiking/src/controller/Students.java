/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import utils.Inputter;

/**
 *
 * @author Acer
 */
public class Students {

    private List<Student> stuList = new ArrayList<>();

    private String pathFile;
    private static boolean isSaved;

    public Students() {
    }

    public Students(String pathFile, boolean isSaved) {
        this.pathFile = pathFile;
        this.isSaved = true;
    }

    public static boolean isSaved() {
        return isSaved;
    }

    public void add(Student x) {
        for (Student stu : stuList) {
            if (stu.getId().equalsIgnoreCase(x.getId())) {
                System.out.println("Dupplicate student ID.");
                return;
            }
        }
        stuList.add(x);
        isSaved = false;
        System.out.println("Student add succesfully");

    }

    public void update(Student x) {

    }

    public void delete(String id) {
        for (Student stu : stuList) {
            if (stu.getId().equalsIgnoreCase(id)) {
                System.out.println(stu);
                String tmp = Inputter.getString("Are you sure you want to delete this registration? (Y/N): ");
                if (tmp.equalsIgnoreCase("y")) {
                    stuList.remove(stu);
                }
            } else {
                System.out.println("Cannot find student with ID: " + id);
            }
        }
        isSaved = false;
    }

    public void searchById(String id) {
        for (Student x : stuList) {
            if (x.getId().equalsIgnoreCase(id)) {
                System.out.println(x);
            } else {
                System.out.println("This student has not registered yet.");
            }
        }
    }

    public void searchByName(String name) {
        for (Student x : stuList) {
            if (x.getName().equalsIgnoreCase(name)) {
                System.out.println(x);
            } else {
                System.out.println("This student has not registered yet");
            }
        }
    }

    public void showAll() {
        for (Student stu : stuList) {
            System.out.println(stu);
        }
    }

    public List<Student> filterByCampus(String campusCode) {
        List<Student> listFilter = new ArrayList<>();
        for (Student stu : stuList) {
            if (stu.getId().substring(0, 1).equalsIgnoreCase(campusCode)) {
                listFilter.add(stu);
            }
        }
        return listFilter;
    }

    public void statisticalizeByMoutainPeak() {

    }

    public void readFromFile() {

    }

    public void saveToFile() {
        if (this.isSaved) {
            return;
        }
        FileOutputStream fos = null;
        try {
            File f = new File(this.pathFile);
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

        } catch (Exception e) {
        }
    }
}
