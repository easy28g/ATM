package sample.service.forUserReg.impl;

import sample.service.forUserReg.CorrectUserNameLoginPassword;

import java.util.regex.Pattern;

public class CorrectUserLoginReg  implements CorrectUserNameLoginPassword {

    private boolean correctUserReg(String userLoginPassword) {
        if(Pattern.matches("[a-zA-Z0-9]+",userLoginPassword) && userLoginPassword.length()>=5){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean nameLoginPassword(String nameLoginPasswordField) {
        return correctUserReg(nameLoginPasswordField);
    }
}
