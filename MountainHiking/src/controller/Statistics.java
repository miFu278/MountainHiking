/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import model.StatisticalInfo;
import model.Student;

/**
 *
 * @author Acer
 */
public class Statistics extends HashMap<String, StatisticalInfo> {

    private final String HEADER_TABLE = "";
    private final String FOOTER_TABLE = "";

    public Statistics() {
        super();
    }

    public Statistics(List<Student> list) {
        super();
        statisticalize(list);
    }


    public void statisticalize(List<Student> list) {
        for (Student stu : list) {
            if (this.containsKey(stu.getMoutainCode())) {
                StatisticalInfo x = this.get(stu.getMoutainCode());
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                x.setTotalCost(x.getTotalCost() + stu.getTuitionFee());

            } else {
                StatisticalInfo z = new StatisticalInfo(stu.getMoutainCode(), 1, stu.getTuitionFee());
                this.put(stu.getMoutainCode(), z);
            }
        }
    }

    public void show() {
        System.out.println(HEADER_TABLE);
        for (StatisticalInfo i : this.values()) {
            System.out.println(i);
        }
        System.out.println(FOOTER_TABLE);
    }

}
