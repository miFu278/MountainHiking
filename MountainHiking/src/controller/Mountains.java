/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mountain;

/**
 *
 * @author Acer
 */
public class Mountains {

    private String pathFile;

    public Mountains() {
    }

    public Mountain get(String mountainCode) {
        FileReader fr = null;
        try {
            File f = new File(this.pathFile);

            if (!f.exists()) {
                System.out.println("MountainList.csv not found !.");
                return null;
            }
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String tmp;

            // Skip the header line
            br.readLine();

            while ((tmp = br.readLine()) != null) {
                Mountain mountain = dataToObject(tmp);
                if (mountain != null && mountain.getMountainCode().equalsIgnoreCase(mountainCode)) {
                    br.close();
                    return mountain;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Mountains.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null; // Mountain not found
    }

    public boolean isValidMountainCode(String mountainCode) {
        
    }

    public Mountain dataToObject(String text) {

    }

    public void readFromFile() {
        FileReader fr = null;
        try {
            File f = new File(this.pathFile);

            if (!f.exists()) {
                System.out.println("MountainList.csv not found !.");
                return;
            }
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String tmp = "";

            while ((tmp = br.readLine()) != null) {
                Mountain i = dataToObject(tmp);
                if (i != null) {
                    this.add(i);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mountain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mountain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Mountain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Mountain.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

}
