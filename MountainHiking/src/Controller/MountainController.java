/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FileHandler;
import Model.Mountain;
import java.util.List;

/**
 *
 * @author mp
 */
public class MountainController {
    
    public static boolean isValidMountainCode(String mountainCode) {
        List<Mountain> mountains = FileHandler.loadMountain();
        for (Mountain mountain : mountains) {
            if (mountain.getMountainCode().equalsIgnoreCase(mountainCode)) {
                return true;
            }
        }
        return false;
    }

    public static String getMountainName(String mountainCode) {
        List<Mountain> mountains = FileHandler.loadMountain();
        for (Mountain mountain : mountains) {
            if (mountain.getMountainCode().equalsIgnoreCase(mountainCode)) {
                return mountain.getMountain();
            }
        }
        return "";
    }


}
