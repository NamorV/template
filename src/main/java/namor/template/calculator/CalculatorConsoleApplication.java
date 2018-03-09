package namor.template.calculator;

import namor.template.stack.ArrayStack;
import namor.template.stack.EmptyStackException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorConsoleApplication {

    public static void main(String args[]) {

        BufferedReader bufferedReader = null;
        RPNcalculator rpNcalculator = new RPNcalculator(new ArrayStack<Double>());
        ClassicCalculator classicCalculator = new ClassicCalculator();

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {

            while(true) {

                System.out.println("Please, enter something!");
                String input = bufferedReader.readLine();

                if ("q".equals(input)) {
                    System.out.println("End program!");
                    System.exit(0);
                } else if (input.isEmpty()) {
                    System.out.println("0");
                } else {
                    calculate(rpNcalculator, classicCalculator, input);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculate(RPNcalculator rpNcalculator, ClassicCalculator classicCalculator, String input) {
        double result;

        try {
            result = rpNcalculator.calculate(input);
            System.out.println(result);
        } catch (Exception e) {
            result = classicCalculator.calculate(input);
            System.out.println(result);
        }
    }
}
