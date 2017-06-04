package namor.template.calculator;

import namor.template.stack.ArrayStack;

public class RPNcalculator {


    public int calculate(String arithmeticExpression) {
        ArrayStack numbers = new ArrayStack();

        for (String operationElement : arithmeticExpression.split(" ")) {
            if (Sign.isSign(operationElement)) {
                doArithmeticOperation(operationElement, numbers);
            } else {
                numbers.push(Integer.parseInt(operationElement));
            }
        }
        return numbers.pop();
    }

    private void doArithmeticOperation(String arithmeticOperator, ArrayStack numbers) {
        switch (Sign.getValue(arithmeticOperator)) {
            case ADDITION:
                numbers.push(addition(numbers));
                break;
            case SUBTRACTION:
                numbers.push(subtraction(numbers));
                break;
            case MULTIPLICATION:
                numbers.push(multiplication(numbers));
                break;
            case DIVISION:
                numbers.push(division(numbers));
                break;
        }
    }

    private final int addition(ArrayStack numbers) {
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber + secondNumber;
    }

    private final int subtraction(ArrayStack numbers) {
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber - secondNumber;
    }

    private final int multiplication(ArrayStack numbers) {
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber * secondNumber;
    }

    private final int division(ArrayStack numbers) {
        final int secondNumber = numbers.pop();
        final int firstNumber = numbers.pop();

        return firstNumber / secondNumber;
    }


}
