/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.MountainController;
import java.io.Serializable;

/**
 *
 * @author mp
 */
public class StatisticInfo implements Serializable {

    private String mountainCode;
    private int numOfStudent;
    private double totalCost;
    private String mountainName;

    public StatisticInfo() {
    }

    public StatisticInfo(String mountainCode, int numOfStudent, double totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
        this.mountainName = MountainController.getMountainName(mountainCode);
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /*-----------------------------------------------------------------
     Peak Name | Number of Participants | Total Cost
    -----------------------------------------------------------------
    MT01 | 5 | 19,500,000
    MT05 | 3 | 18,000,000
    -----------------------------------------------------------------*/
    @Override
    public String toString() {
        return String.format(" %-20s | %22s | %,.0f ", mountainName, numOfStudent, totalCost);
    }

}
