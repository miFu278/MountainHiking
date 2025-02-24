/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Mountain;
import java.util.List;

/**
 *
 * @author Acer
 */
public class MountainView {

    public static void displayMountain(List<Mountain> mountains) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" Mountain Code | Name                 | Province                 ");
        System.out.println("-----------------------------------------------------------------");
        for (Mountain mountain : mountains) {
            if (mountain.getMountainCode().equalsIgnoreCase("code")) {
                continue;
            }
            System.out.printf(" %-13s | %-20s | %-24s \n",
                    mountain.getMountainCode(),
                    mountain.getMountain(),
                    mountain.getProvince()
            );
        }
        System.out.println("-----------------------------------------------------------------");
    }

}
