package namor.template.calculator;

import namor.template.stack.Stack;

public class RPNcalculator {

    private Stack<Double> operands;

    public RPNcalculator(Stack operands) {
        this.operands = operands;
    }

    public double calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            if (Sign.isSign(operationElement)) {
                doArithmeticOperation(operationElement, operands);
            } else {
                operands.push(Double.parseDouble(operationElement));
            }
        }
        return operands.pop();
    }

    private void doArithmeticOperation(String arithmeticOperator, Stack numbers) {
        switch (Sign.getValue(arithmeticOperator)) {
            case ADDITION:
                numbers.push(add(numbers));
                break;
            case SUBTRACTION:
                numbers.push(subtract(numbers));
                break;
            case MULTIPLICATION:
                numbers.push(multiplication(numbers));
                break;
            case DIVISION:
                numbers.push(divide(numbers));
                break;
        }
    }

    private final double add(Stack<Double> numbers) {
        final double secondNumber = numbers.pop();
        final double firstNumber = numbers.pop();

        return firstNumber + secondNumber;
    }

    private final double subtract(Stack<Double> numbers) {
        final double secondNumber = numbers.pop();
        final double firstNumber = numbers.pop();

        return firstNumber - secondNumber;
    }

    private final double multiplication(Stack<Double> numbers) {
        final double secondNumber = numbers.pop();
        final double firstNumber = numbers.pop();

        return firstNumber * secondNumber;
    }

    private final double divide(Stack<Double> numbers) {
        final double secondNumber = numbers.pop();
        final double firstNumber = numbers.pop();

        return firstNumber / secondNumber;
    }


}