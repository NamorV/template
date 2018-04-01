package namor.template.calculator;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorFactoryTest {

    private CalculatorFactory calculatorFactory;

    @Test
    public void whenInputRpnExpressionReturnRPNCalculator() {
        final String input = "1 1 +";
        final Calculator actual;
        calculatorFactory = new CalculatorFactory();

        actual = calculatorFactory.get(input);
        assertThat(actual.getClass()).isEqualTo(RPNcalculator.class);
    }

    @Test
    public void whenInputClassicExpressionReturnClassicCalculator() {
        final String input = "1 + 1";
        final Calculator actual;
        calculatorFactory = new CalculatorFactory();

        actual = calculatorFactory.get(input);
        assertThat(actual.getClass()).isEqualTo(ClassicCalculator.class);
    }

    @Test
    public void whenInputEmptyReturnClassicCalculator() {
        final String input = null;
        final Calculator actual;
        calculatorFactory = new CalculatorFactory();

        actual = calculatorFactory.get(input);
        assertThat(actual.getClass()).isEqualTo(ClassicCalculator.class);
    }
}
