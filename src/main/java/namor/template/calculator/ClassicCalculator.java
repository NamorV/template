package namor.template.calculator;

import java.util.LinkedList;

public class ClassicCalculator {

    private LinkedList<String> operands;

    public ClassicCalculator() {
        this.operands = new LinkedList<>();
    }

    public double calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            operands.addLast(operationElement);
        }

        while (operands.size() != 1) {
            doArithmeticOperation();
        }

        return Double.parseDouble(operands.pop());
    }

    private void doArithmeticOperation () {
        int listPosition = 0;
        double result;

        while (!Sign.isSign(operands.get(listPosition))) {
            listPosition++;
        }

        switch (Sign.getValue(operands.get(listPosition))) {
            case ADDITION:
                result = add(listPosition);
                operands.addFirst(String.valueOf(result));
                break;
            case SUBTRACTION:
                result = subtract(listPosition);
                operands.addFirst(String.valueOf(result));
                break;
            case MULTIPLICATION:
                result = multiply(listPosition);
                operands.addFirst(String.valueOf(result));
                break;
            case DIVISION:
                result = divide(listPosition);
                operands.addFirst(String.valueOf(result));
                break;
        }

    }

    private final double add(int listPosition) {
        final double firstNumber = Double.parseDouble(operands.remove(listPosition - 1));
        final double secondNumber = Double.parseDouble(operands.remove(listPosition));
        operands.removeFirst();

        return firstNumber + secondNumber;
    }

    private final double subtract(int listPosition) {
        final double firstNumber = Double.parseDouble(operands.remove(listPosition - 1));
        final double secondNumber = Double.parseDouble(operands.remove(listPosition));
        operands.removeFirst();

        return firstNumber - secondNumber;
    }

    private final double multiply(int listPosition) {
        final double firstNumber = Double.parseDouble(operands.remove(listPosition - 1));
        final double secondNumber = Double.parseDouble(operands.remove(listPosition));
        operands.removeFirst();

        return firstNumber * secondNumber;
    }

    private final double divide(int listPosition) {
        final double firstNumber = Double.parseDouble(operands.remove(listPosition - 1));
        final double secondNumber = Double.parseDouble(operands.remove(listPosition));
        operands.removeFirst();

        return firstNumber / secondNumber;
    }
}
