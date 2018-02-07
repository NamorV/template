package namor.template.calculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClassicCalculator {

    private LinkedList<String> operands;
    private List<String> operands1;

    public ClassicCalculator() {
        this.operands = new LinkedList<>();
    }

    public double calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            operands.addLast(operationElement);
        }

        operands1 = Collections.unmodifiableList(operands);
        double result = Double.parseDouble(operands1.get(0));

        for (int iterator = 1; iterator < operands1.size() - 1; iterator = iterator + 2) {
            result = doArithmeticOperation(result, operands1.get(iterator), operands1.get(iterator + 1));
        }

        return result;
    }

    private double doArithmeticOperation (double result, String sign, String number) {
         switch (Sign.getValue(sign)) {
            case ADDITION:
                result = result + Double.parseDouble(number);
                break;
            case SUBTRACTION:
                result = result - Double.parseDouble(number);
                break;
            case MULTIPLICATION:
                result = result * Double.parseDouble(number);
                break;
            case DIVISION:
                result = result / Double.parseDouble(number);
                break;
        }

        return result;
    }
}
