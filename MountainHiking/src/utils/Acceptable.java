/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

/**
 *
 * @author Acer
 */
public interface Acceptable {

    public final String STU_ID_VALID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^.{2,20}$";
//    public final String PHONE_VALID = "^(086|096|097|098|039|038|037|036|035|034|032|" //viettel
//            + "091|094|088|083|084|085|081|082" //vinaphone
//            + "070|079|077|076|078|089|090|093" //mobiphone
//            + ")\\d{7}$";
    public final String PHONE_VALID = "^0\\d{9}$";
    public final String VIETTEL_VALID = "^(086|096|097|098|039|038|037|036|035|034|032)\\d{7}$";
    public final String VNPT_VALID = "^(091|094|088|083|084|085|081|082)\\d{7}$";
    public final String EMAIL_VALID = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    public final String INT_VALID = "^-?\\d+$";
    public final String DOUBLE_VALID = "^-?\\d+(\\.\\d+)?$";

    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
