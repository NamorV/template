package namor.template.calculator;

import namor.template.stack.ArrayStack;
import namor.template.stack.MapBasedStack;
import namor.template.stack.Stack;

public class RPNcalculator<T extends Number>{
    private final Class<T> type;
    private Stack<T> numbers;

    public Stack<T> getNumbers() {
        return numbers;
    }

    public RPNcalculator(Class<T> type, Class stack) {
        if (stack.equals(ArrayStack.class)){
            numbers = new ArrayStack<>();
        } else if (stack.equals(MapBasedStack.class)){
            numbers = new MapBasedStack<>();
        }
        this.type = type;
    }

    private Class<T> getMyType() {
        return this.type;
    }

    public T calculate(String arithmeticExpression) {

        for (String operationElement : arithmeticExpression.split(" ")) {
            if (Sign.isSign(operationElement)) {
                doArithmeticOperation(operationElement, numbers);
            } else {
                convertStringToNumber(getMyType(), numbers, operationElement);
            }
        }
        return numbers.pop();
    }

    private void doArithmeticOperation(String arithmeticOperator, Stack<T> numbers) {
        switch (Sign.getValue(arithmeticOperator)) {
            case ADDITION:
                numbers.push(addition(numbers.pop(), numbers.pop()));
                break;
            case SUBTRACTION:
                numbers.push(subtraction(numbers.pop(), numbers.pop()));
                break;
            case MULTIPLICATION:
                numbers.push(multiplication(numbers.pop(), numbers.pop()));
                break;
            case DIVISION:
                numbers.push(division(numbers.pop(), numbers.pop()));
                break;
        }
    }

    private void convertStringToNumber(Class<T> type, Stack<T> numbers, String operationElement) {
        if(type == Integer.class) {
            numbers.push((T)(Integer)(Integer.parseInt(operationElement)));
        } else if(type == Double.class) {
            numbers.push((T)(Double)(Double.parseDouble(operationElement)));
        } else if(type == Float.class) {
            numbers.push((T)(Float)(Float.parseFloat(operationElement)));
        } else {
            numbers.push((T)(Long)(Long.parseLong(operationElement)));
        }
    }

    private final <T> T addition(T firstNumber, T secondNumber) {
        if (firstNumber.getClass() == Integer.class) {
            return (T)(Integer)((Integer) secondNumber + (Integer) firstNumber);
        } else if (firstNumber.getClass() == Double.class) {
            return (T) (Double) ((Double) secondNumber + (Double) firstNumber);
        } else if (firstNumber.getClass() == Float.class) {
            return (T) (Float) ((Float) secondNumber + (Float) firstNumber);
        } else {
            return (T) (Long) ((Long) secondNumber + (Long) firstNumber);
        }
    }

    private final <T> T subtraction(T firstNumber, T secondNumber) {
        if (firstNumber.getClass() == Integer.class) {
            return (T)(Integer)((Integer) secondNumber - (Integer) firstNumber);
        } else if (firstNumber.getClass() == Double.class) {
            return (T) (Double) ((Double) secondNumber - (Double) firstNumber);
        } else if (firstNumber.getClass() == Float.class) {
            return (T) (Float) ((Float) secondNumber - (Float) firstNumber);
        } else {
            return (T) (Long) ((Long) secondNumber - (Long) firstNumber);
        }
    }

    private final <T> T multiplication(T firstNumber, T secondNumber) {
        if (firstNumber.getClass() == Integer.class) {
            return (T)(Integer)((Integer) secondNumber * (Integer) firstNumber);
        } else if (firstNumber.getClass() == Double.class) {
            return (T) (Double) ((Double) secondNumber * (Double) firstNumber);
        } else if (firstNumber.getClass() == Float.class) {
            return (T) (Float) ((Float) secondNumber * (Float) firstNumber);
        } else {
            return (T) (Long) ((Long) secondNumber * (Long) firstNumber);
        }
    }

    private final <T> T division(T firstNumber, T secondNumber) {
        if (firstNumber.getClass() == Integer.class) {
            return (T)(Integer)((Integer) secondNumber / (Integer) firstNumber);
        } else if (firstNumber.getClass() == Double.class) {
            return (T) (Double) ((Double) secondNumber / (Double) firstNumber);
        } else if (firstNumber.getClass() == Float.class) {
            return (T) (Float) ((Float) secondNumber / (Float) firstNumber);
        } else {
            return (T) (Long) ((Long) secondNumber / (Long) firstNumber);
        }
    }


}
