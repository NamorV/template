package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {
    private ArrayStack numbers = new ArrayStack();
    Sign sign;

    public int calculate(String inputString){
        for(String splitData : inputString.split(" ")){
                A(splitData);
        }
        return numbers.pop();
    }

    private void A(String splitData) {
        switch (sign.getValue(splitData)){
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
            case NUMBER:
                numbers.push(Integer.parseInt(splitData));
                break;
        }
    }

    private final int addition(){
        int result;
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        result = firstNumber + secondNumber;
        return result;
    }

    private final int subtraction(){
        int result;
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        result = firstNumber - secondNumber;
        return result;
    }

    private final int multiplication(){
        int result;
        final int  secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        result = firstNumber * secondNumber;
        return result;
    }

    private final int division(){
        int result;
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        result = firstNumber / secondNumber;
        return result;
    }
}
