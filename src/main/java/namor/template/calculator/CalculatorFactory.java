package namor.template.calculator;


import namor.template.stack.ArrayStack;

public class CalculatorFactory {

    public Calculator get(String inputString) {
        String element = null;

        if(!inputString.isEmpty()){
            element = String.valueOf(inputString.charAt(inputString.length() - 1));
        }

        if(Sign.isSign(element)) {
            return new RPNcalculator(new ArrayStack<Double>());
        }else {
            return new ClassicCalculator();
        }
    }
}
