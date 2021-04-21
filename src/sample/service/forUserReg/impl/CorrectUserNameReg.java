package sample.service.forUserReg.impl;

import sample.service.forUserReg.CorrectUserNameLoginPassword;

import java.util.regex.Pattern;

public class CorrectUserNameReg  implements CorrectUserNameLoginPassword {

    private boolean correctUserReg(String userLoginPassword) {
        if(Pattern.matches("^[а-яА-ЯёЁ\s]+$",userLoginPassword) && userLoginPassword.length()>=3){
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
