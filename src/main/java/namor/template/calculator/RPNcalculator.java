package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {
    private int result;
    private ArrayStack numbers = new ArrayStack();
    private Signs sign;

    public void isCorrect(String rpnString) throws IllegalArgumentException {
        if(rpnString == null || rpnString == ""){
            throw new IllegalArgumentException("Input string is empty!");
        }

        for(int i = 0; i < rpnString.length(); i++){
            char x;
            x = rpnString.charAt(i);

            if(!(Character.isDigit(x) || x == '/' || x == '*' ||
                    x == '+'|| x== '-' || x == ' ')){
                throw new IllegalArgumentException("Input elements are wrong!");
            }
        }
    }

    public int calculate(String rpnString){
        int firstNumber;
        int secondNumber;

        for (String retval: rpnString.split(" ")) {
            if(retval.matches("^[0-9]+$")){
                numbers.push(Integer.parseInt(retval));
            } else {
                secondNumber = numbers.pop();
                firstNumber = numbers.pop();

                if(sign.ADDITION.getKey().equals(retval)){
                    result += firstNumber + secondNumber;
                } else if(sign.SUBSTRACTION.getKey().equals(retval)){
                    result += firstNumber - secondNumber;
                } else if(sign.MULTIPLICATION.getKey().equals(retval)){
                    result += firstNumber * secondNumber;
                } else if (sign.DIVISION.getKey().equals(retval)){
                    result += firstNumber / secondNumber;
                }
            }
        }

        return result;
    }
}
