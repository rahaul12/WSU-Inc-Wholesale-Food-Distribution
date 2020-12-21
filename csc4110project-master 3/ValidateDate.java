//package com.inventory.jd;

public class ValidateDate implements ValidateClass{
    @Override
    public boolean validate(String date) {
        if(date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")){
            return true;
        }else{
            return false;
        }
    }
}
