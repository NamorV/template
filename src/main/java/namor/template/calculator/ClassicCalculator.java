package namor.template.calculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClassicCalculator {

    private LinkedList<String> operands;
    private List<String> someName;

    public ClassicCalculator() {
        this.operands = new LinkedList<>();
    }

    public double calculate(String arithmeticExpression) {
        int listPosition = 1;
        double result;

        for (String operationElement : arithmeticExpression.split(" ")) {
            operands.addLast(operationElement);
        }

        someName = Collections.unmodifiableList(operands);
        result = Double.parseDouble(someName.get(0));

        while (listPosition < (someName.size() - 1)) {
            result = doArithmeticOperation(listPosition, result);
            listPosition += 2;
        }

        return result;
    }

    private double doArithmeticOperation (int listPosition, double result) {
        switch (Sign.getValue(someName.get(listPosition))) {
            case ADDITION:
                result = add(listPosition, result);
                break;
            case SUBTRACTION:
                result = subtract(listPosition, result);
                break;
            case MULTIPLICATION:
                result = multiply(listPosition, result);
                break;
            case DIVISION:
                result = divide(listPosition, result);
                break;
        }
        return result;

    }

    private final double add(int listPosition, double firstNumber) {
        final double secondNumber = Double.parseDouble(someName.get(listPosition + 1));

        return firstNumber + secondNumber;
    }

    private final double subtract(int listPosition, double firstNumber) {
        final double secondNumber = Double.parseDouble(someName.get(listPosition + 1));

        return firstNumber - secondNumber;
    }

    private final double multiply(int listPosition, double firstNumber) {
        final double secondNumber = Double.parseDouble(someName.get(listPosition + 1));

        return firstNumber * secondNumber;
    }

    private final double divide(int listPosition, double firstNumber) {
        final double secondNumber = Double.parseDouble(operands.get(listPosition + 1));

        return firstNumber / secondNumber;
    }
}
