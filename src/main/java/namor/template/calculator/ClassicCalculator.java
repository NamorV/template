package namor.template.calculator;

import namor.template.stack.Stack;

public class ClassicCalculator {

    private Stack<Double> operands;
    private String sign = null;

    public ClassicCalculator(Stack operands) {
        this.operands = operands;
    }

    public double calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            if (Sign.isSign(operationElement)) {
                useSign(operationElement, operands);
            } else {
                operands.push(Double.parseDouble(operationElement));
            }
        }

        useSign(null, operands);
        return operands.pop();
    }

    private void useSign(String arithmeticOperator, Stack numbers) {
        if (sign == null) {
            sign = arithmeticOperator;
        } else if (sign != null) {
            doArithmeticOperation(sign, numbers);
            sign = arithmeticOperator;
        }
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
}
