/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mp
 */
public class FileHandler {

    private static final String MOUNTAINS_FILE = "src/data/Mountainlist.csv";
    private static final String REGISTRATION_FILE = "src/data/registration.dat";

    public static void saveRegistration(List<Student> students) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(REGISTRATION_FILE))) {
            oos.writeObject(new ArrayList<>(students));
            System.out.println("Registers data has been successfully saved to \"" + REGISTRATION_FILE + "\"");
        }
    }

    public static List<Student> loadRegistration() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(REGISTRATION_FILE))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Load mountains from CSV file (unchanged)
    public static List<Mountain> loadMountain() {
        List<Mountain> mountains = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MOUNTAINS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String mountainCode = parts[0].trim();
                    String name = parts[1].trim();
                    String provice = parts[2].trim();
                    String description = parts[3].trim();
                    mountains.add(new Mountain(mountainCode, name, provice, description));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading menus: " + e.getMessage());
        }
        return mountains;
    }

}
