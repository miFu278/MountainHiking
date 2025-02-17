/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.StatisticInfo;
import Model.Student;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mp
 */
public class StatisticController extends HashMap<String, StatisticInfo> {

    public StatisticController() {
        super();
    }

    public StatisticController(List<Student> list) {
        super();
        statisticalize(list);
    }

    public final void statisticalize(List<Student> list) {
        for (Student stu : list) {
            if (this.containsKey(stu.getMountainCode())) {
                StatisticInfo x = this.get(stu.getMountainCode());
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                x.setTotalCost(x.getTotalCost() + stu.getTuitionFee());
            } else {
                StatisticInfo z = new StatisticInfo(stu.getMountainCode(), 1, stu.getTuitionFee());
                this.put(stu.getMountainCode(), z);
            }
        }
    }

    public void displayStatistic() {
        /*
        -----------------------------------------------------------------
        Peak Name | Number of Participants | Total Cost
        -----------------------------------------------------------------
        MT01 | 5 | 19,500,000
        MT05 | 3 | 18,000,000
        -----------------------------------------------------------------*/
        System.out.println("-----------------------------------------------------------------\n"
                + " Peak Name | Number of Participants | Total Cost\n"
                + "-----------------------------------------------------------------");
        for (StatisticInfo i : this.values()) 
            System.out.println(i);
        System.out.println("-----------------------------------------------------------------");

    }

}
