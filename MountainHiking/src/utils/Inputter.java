/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import model.Student;

/**
 *
 * @author Acer
 */
public class Inputter {

    private final static Scanner sc = new Scanner(System.in);

    public static String getString(String mess) {
        String res = "";
        System.out.println(mess);
        res = sc.nextLine();
        return res;
    }

    private static int getInt(String mess) {
        int res = 0;
        String tmp = getString(mess);
        if (Acceptable.isValid(tmp, Acceptable.INT_VALID)) {
            res = Integer.parseInt(tmp);
        }
        return res;
    }

    private static double getDouble(String mess) {
        double res = 0;
        String tmp = getString(mess);
        if (Acceptable.isValid(tmp, Acceptable.DOUBLE_VALID)) {
            res = Double.parseDouble(tmp);
        }
        return res;
    }

    public static String inputAndLoop(String mess, String pattern) {
        String res = "";
        boolean more = true;
        do {
            res = getString(mess);
            more = !Acceptable.isValid(res, pattern);
            if (more) {
                System.out.println("Data is invalid!. Re-enter...");
            }
        } while (more);
        return res.trim();
    }

    public static Student enterStudentInfo(boolean isUpdated) {
        Student newStu = new Student();
        newStu.setId(inputAndLoop("Student id: ", Acceptable.STU_ID_VALID));
        newStu.setName(inputAndLoop("Student name: ", Acceptable.NAME_VALID));
        newStu.setPhone(inputAndLoop("Phone number [10 digits]: ", Acceptable.PHONE_VALID));
        newStu.setEmail(inputAndLoop("Email address: ", Acceptable.EMAIL_VALID));
        return newStu;
    }
}
