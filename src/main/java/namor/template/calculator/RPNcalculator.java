package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {
    private int result;
    private ArrayStack numbers = new ArrayStack();

    public void isCorrect(String rpnString) throws IllegalArgumentException {
        if(rpnString == null || rpnString == ""){
            throw new IllegalArgumentException("Input string is empty!");
        }

        for(int i = 0; i < rpnString.length(); i++){
            char x;
            x = rpnString.charAt(i);

            if(!(Character.isDigit(x) || x == '/' || x == '*' ||
                    x == '+'|| x == '-' || x == ' ')){
                throw new IllegalArgumentException("Input elements are wrong!");
            }
        }
    }

    public int calculate(String rpnString){
        int firstNumber;
        int secondNumber;

        isCorrect(rpnString);

        for (String retval: rpnString.split(" ")) {
            if(retval.matches("^[0-9]+$")){
                numbers.push(Integer.parseInt(retval));
            } else {

                if(Signs.ADDITION.getKey().equals(retval)){
                    secondNumber = numbers.pop();
                    firstNumber = numbers.pop();
                    result = firstNumber + secondNumber;
                    numbers.push(result);
                } else if(Signs.SUBSTRACTION.getKey().equals(retval)){
                    secondNumber = numbers.pop();
                    firstNumber = numbers.pop();
                    result = firstNumber - secondNumber;
                    numbers.push(result);
                } else if(Signs.MULTIPLICATION.getKey().equals(retval)){
                    secondNumber = numbers.pop();
                    firstNumber = numbers.pop();
                    result = firstNumber * secondNumber;
                    numbers.push(result);
                } else if (Signs.DIVISION.getKey().equals(retval)){
                    secondNumber = numbers.pop();
                    firstNumber = numbers.pop();
                    result = firstNumber / secondNumber;
                    numbers.push(result);
                } else {
                    throw new IllegalArgumentException("Input elements are wrong!");
                }
            }
        }

        return result;
    }
}
