//package com.inventory.jd;

public class ValidateCodeQuantity implements ValidateClass{
    @Override
    public boolean validate(String code) {
        if(code.matches("[0-9]+")){
            return true;
        }else{
            return false;
        }
    }
}
