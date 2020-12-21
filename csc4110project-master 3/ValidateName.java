//package com.inventory.jd;

public class ValidateName implements ValidateClass{

    @Override
    public boolean validate(String name) {
        if(name.matches("[a-zA-Z]+")){
            return true;
        }else{
            return false;
        }
    }
}
