package namor.template.calculator;

import namor.template.stack.ArrayStack;
import namor.template.stack.MapBasedStack;
import org.junit.Before;
import org.junit.Test;

import java.util.zip.DeflaterOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNcalculatorTest {

    private RPNcalculator rpnCalculator;

    @Test
    public void addTwoNumbers() {
        final double expected = 6.4;
        final double actual;
        rpnCalculator = new RPNcalculator(new ArrayStack<Double>());
        final String arithmeticExpression = "2.1 4.3 +";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void substactTwoNumbers() {
        final double expected = 5;
        final double actual;
        rpnCalculator = new RPNcalculator(new ArrayStack<Float>());
        final String arithmeticExpression = "10 5 -";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers() {
        final double expected = 45;
        final double actual;
        rpnCalculator = new RPNcalculator(new ArrayStack<Long>());
        final String arithmeticExpression = "9 5 *";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers() {
        final double expected = 7;
        final double actual;
        rpnCalculator = new RPNcalculator(new ArrayStack<Integer>());
        final String arithmeticExpression = "49 7 /";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenTwoArithmaticOperatinsDoneReurnsCorrectNumber() {
        final double expected = 11;
        final double actual;
        rpnCalculator = new RPNcalculator(new ArrayStack<Integer>());
        final String arithmeticExpression = "49 7 / 4 +";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }
}