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
        double result;
        switch (Sign.getValue(arithmeticOperator)) {
            case ADDITION:
                result = add(numbers);
                numbers.push(result);
                break;
            case SUBTRACTION:
                result = subtract(numbers);
                numbers.push(result);
                break;
            case MULTIPLICATION:
                result = multiplication(numbers);
                numbers.push(result);
                break;
            case DIVISION:
                result = divide(numbers);
                numbers.push(result);
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