package namor.template.calculator;

import namor.template.stack.Stack;

public class RPNcalculator {

    private Stack numbers;

    public RPNcalculator(Stack stk) {
        this.numbers = stk;
    }

    public double calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            if (Sign.isSign(operationElement)) {
                doArithmeticOperation(operationElement, numbers);
            } else {
                numbers.push(Double.parseDouble(operationElement));
            }
        }
        return (double) numbers.pop();
    }

    private void doArithmeticOperation(String arithmeticOperator, Stack numbers) {
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

    private final double addition(Stack numbers) {
        final double secondNumber = (Double) numbers.pop();
        final double firstNumber = (Double) numbers.pop();

        return firstNumber + secondNumber;
    }

    private final double subtraction(Stack numbers) {
        final double secondNumber = (Double) numbers.pop();
        final double firstNumber = (Double) numbers.pop();

        return firstNumber - secondNumber;
    }

    private final double multiplication(Stack numbers) {
        final double secondNumber = (Double) numbers.pop();
        final double firstNumber = (Double) numbers.pop();

        return firstNumber * secondNumber;
    }

    private final double division(Stack numbers) {
        final double secondNumber = (Double) numbers.pop();
        final double firstNumber = (Double) numbers.pop();

        return firstNumber / secondNumber;
    }


}