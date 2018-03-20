package namor.template.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorConsoleApplication {

    public static void main(String args[]) {

        double result;
        BufferedReader bufferedReader;
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        Calculator calculator;

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
                    calculator = calculatorFactory.getCalculator(input);
                    result = calculator.calculate(input);
                    System.out.println(result);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
