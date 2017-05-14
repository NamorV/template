package namor.template.calculator;

public class RPNcalculator {

    public void isCorrect(String rpnString) throws IllegalArgumentException {
        if(rpnString == null || rpnString == ""){
            throw new IllegalArgumentException("Input string is empty!");
        }

        for(int i = 0; i < rpnString.length(); i++){
            char x = rpnString.charAt(i);

            if(!(Character.isDigit(x) || x == '/' || x == '*' ||
                    x == '+'|| x== '-' || x=='%'  ||
                    x == ' ')){
                throw new IllegalArgumentException("Input elements are wrong!");
            }
        }
    }


}
