package namor.template.calculator;

public class RPNcalculator {

    public boolean isCorrect(String rpnString){
        for(int i = 0; i < rpnString.length(); i++){
            char x = rpnString.charAt(i);
            if(!(Character.isDigit(x) || x == '/' || x == '*' ||
                    x == '+'|| x== '-' || x=='%' || x == '\n' ||
                    x == ' ')){
                return false;
            }
        }
        return true;
    }
}
