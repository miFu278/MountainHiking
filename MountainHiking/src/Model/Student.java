package Model;

import java.io.Serializable;
import Utils.Acceptable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mp
 */
public class Student implements Serializable {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tuitionFee;

    public Student() {
    }

    public Student(String id, String name, String phone, String email, String mountainCode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = calcTuitionFee();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public double calcTuitionFee() {
        double baseFee = 6000000;
        if (Acceptable.isValid(this.phone, Acceptable.VNPT_VALID) || Acceptable.isValid(this.phone, Acceptable.VIETTEL_VALID)) {
            return baseFee * 0.65;
        }
        return baseFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------------------\n")
                .append("Student ID: ").append(id.toUpperCase()).append("\n")
                .append("Name      : ").append(name).append("\n")
                .append("Phone     : ").append(phone).append("\n")
                .append("Mountain  : ").append("MT").append(mountainCode).append("\n")
                .append("Fee       : ").append(String.format("%,.0f", tuitionFee)).append("\n")
                .append("-----------------------------------------------------");
        return sb.toString();
    }

}
