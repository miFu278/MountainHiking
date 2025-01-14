/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class StatisticalInfo {

    private String mountainCode;
    private int numOfStudent;
    private double totalCost;

    public StatisticalInfo() {
    }

    public StatisticalInfo(String mountainCode, int numOfStudent, double totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
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

    @Override
    public String toString() {
        return "StatisticallInfo{" + "mountainCode=" + mountainCode + ", numOfStudent=" + numOfStudent + ", totalCost=" + totalCost + '}';
    }
    
    
}
