package namor.template.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RPNcalculatorTest {

    private RPNcalculator<Integer> rpnCalculator;

    @Before
    public void setUp() {
        rpnCalculator = new RPNcalculator<>(Integer.class);
    }

    @Test
    public void addTwoNumbers() {
        final int expected = 6;
        final int actual;
        final String arithmeticExpression = "2 4 +";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void substactTwoNumbers() {
        final int expected = 5;
        final int actual;
        final String arithmeticExpression = "10 5 -";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers() {
        final int expected = 45;
        final int actual;
        final String arithmeticExpression = "9 5 *";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers() {
        final int expected = 7;
        final int actual;
        final String arithmeticExpression = "49 7 /";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenTwoArithmaticOperatinsDoneReurnsCorrectNumber() {
        final int expected = 11;
        final int actual;
        final String arithmeticExpression = "49 7 / 4 +";

        actual = rpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void stackWorksWithFloat() {
        RPNcalculator<Float> FrpnCalculator = new RPNcalculator<>(Float.class);
        final float expected = 4.4f;
        final float actual;
        final String arithmeticExpression = "2.2 3.3 + 1.1 -";

        actual = FrpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void stackWorksWithDouble() {
        RPNcalculator<Double> FrpnCalculator = new RPNcalculator<>(Double.class);
        final double expected = 4.4;
        final double actual;
        final String arithmeticExpression = "2.2 3.3 + 1.1 -";

        actual = FrpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void stackWorksWithLong() {
        RPNcalculator<Long> FrpnCalculator = new RPNcalculator<>(Long.class);
        final long expected = 4L;
        final long actual;
        final String arithmeticExpression = "2 3 + 1 -";

        actual = FrpnCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

}