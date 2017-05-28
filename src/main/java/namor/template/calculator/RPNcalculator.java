package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {
    private ArrayStack numbers = new ArrayStack();
    Sign sign;

    public int calculate(String rpnString){
        int count = 0;
        String[] retval = rpnString.split(" ");

         while (retval.length > count){
            if(retval[count].matches("^[0-9]+$")){
                numbers.push(Integer.parseInt(retval[count]));
            } else {
                switch (sign.getValue(retval[count])){
                    case ADDITION:
                        numbers.push(addition());
                        break;
                    case SUBTRACTION:
                        numbers.push(subtraction());
                        break;
                    case MULTIPLICATION:
                        numbers.push(multiplication());
                        break;
                    case DIVISION:
                        numbers.push(division());
                        break;
                    default:
                        throw new IllegalArgumentException("Input elements are wrong!");
                }
            }
            count++;
        }

        return numbers.pop();
    }

    private int addition(){
        int result;
        int firstNumber;
        int secondNumber;

        secondNumber = numbers.pop();
        firstNumber = numbers.pop();
        result = firstNumber + secondNumber;
        return result;
    }

    private int subtraction(){
        int result;
        int firstNumber;
        int secondNumber;

        secondNumber = numbers.pop();
        firstNumber = numbers.pop();
        result = firstNumber - secondNumber;
        return result;
    }

    private int multiplication(){
        int result;
        int firstNumber;
        int secondNumber;

        secondNumber = numbers.pop();
        firstNumber = numbers.pop();
        result = firstNumber * secondNumber;
        return result;
    }

    private int division(){
        int result;
        int firstNumber;
        int secondNumber;

        secondNumber = numbers.pop();
        firstNumber = numbers.pop();
        result = firstNumber / secondNumber;
        return result;
    }
}
