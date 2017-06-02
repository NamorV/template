package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {
    private ArrayStack numbers = new ArrayStack();

    public int calculate(String arithmeticExpression){
        for(String splitData : arithmeticExpression.split(" ")){
            if(Sign.isSign(splitData)){
                doArithmeticOperation(splitData);
            } else {
                numbers.push(Integer.parseInt(splitData));
            }
        }
        return numbers.pop();
    }

    private void doArithmeticOperation(String sign) {
        switch (Sign.getValue(sign)){
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
        }
    }

    private final int addition(){
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber + secondNumber;
    }

    private final int subtraction(){
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();
        
        return firstNumber - secondNumber;
    }

    private final int multiplication(){
        final int  secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();
        
        return firstNumber * secondNumber;
    }

    private final int division(){
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber / secondNumber;
    }


}
