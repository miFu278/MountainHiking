/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import utils.Acceptable;

/**
 *
 * @author Acer
 */
public class Student implements Serializable {

    private String id, name, phone, email, moutainCode;
    private double tuitionFee;

    public Student() {
    }

    public Student(String id, String name, String phone, String email, String moutainCode, double tuitionFee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.moutainCode = moutainCode;
        this.tuitionFee = 6000000;
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

    public String getMoutainCode() {
        return moutainCode;
    }

    public void setMoutainCode(String moutainCode) {
        this.moutainCode = moutainCode;
    }

    public double getTuitionFee() {
        return (this.phone == Acceptable.VIETTEL_VALID || this.phone == Acceptable.VNPT_VALID)
                ? this.tuitionFee * 0.65 : this.tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
//
//    @Override
//    public String toString() {
//        return String.format("%-10s | %-15s | %-10s | %-8s | %.2f",
//                id, name, phone, moutainCode, tuitionFee);
//    }
//    
//    -----------------------------------------------------
//Student ID: SE123456 
//Name : John Doe 
//Phone : 0987654321 
//Mountain : MT01 
//Fee : 3,900,000 
//-----------------------------------------------------

    @Override
    public String toString() {
        return "-----------------------------------------------------\n"
                + "Student ID: " + this.id
                + "\nName: " + this.name
                + "\nPhone:" + this.phone
                + "\nMountain: " + this.moutainCode
                + "\nFee: " + this.getTuitionFee()
                + "-----------------------------------------------------";
    }

}
