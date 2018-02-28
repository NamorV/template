package namor.template.calculator;

import java.util.Arrays;
import java.util.LinkedList;

public class ClassicCalculator {

    public double calculate(String arithmeticExpression) {
        LinkedList<String> operands = new LinkedList<>();
        String[] operationElements = arithmeticExpression.split(" ");

        operands.addAll(Arrays.asList(operationElements));

        while(operands.size() > 1) {
            doArithmeticOperation(operands, operands.poll(), operands.poll(), operands.poll());
        }

        return Double.parseDouble(operands.poll());
    }

    private void doArithmeticOperation (LinkedList<String> operands, String firstNumber, String sign, String secondNumber) {
        switch (Sign.getValue(sign)) {
            case ADDITION:
                operands.addFirst(add(firstNumber, secondNumber));
                break;
            case SUBTRACTION:
                operands.addFirst(subtract(firstNumber, secondNumber));
                break;
            case MULTIPLICATION:
                operands.addFirst(multiply(firstNumber, secondNumber));
                break;
            case DIVISION:
                operands.addFirst(divide(firstNumber, secondNumber));
                break;
        }
    }

    private final String add(String firstString, String secondString) {
        final double secondNumber = Double.parseDouble(secondString);
        final double firstNumber = Double.parseDouble(firstString);

        return String.valueOf(firstNumber + secondNumber);
    }

    private final String subtract(String firstString, String secondString) {
        final double secondNumber = Double.parseDouble(secondString);
        final double firstNumber = Double.parseDouble(firstString);

        return String.valueOf(firstNumber - secondNumber);
    }

    private final String multiply(String firstString, String secondString) {
        final double secondNumber = Double.parseDouble(secondString);
        final double firstNumber = Double.parseDouble(firstString);

        return String.valueOf(firstNumber * secondNumber);
    }

    private final String divide(String firstString, String secondString) {
        final double secondNumber = Double.parseDouble(secondString);
        final double firstNumber = Double.parseDouble(firstString);

        return String.valueOf(firstNumber / secondNumber);
    }
}