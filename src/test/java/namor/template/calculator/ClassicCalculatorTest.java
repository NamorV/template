package namor.template.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicCalculatorTest {

    private ClassicCalculator classicCalculator;

    @Test
    public void addThreeNumbers() {
        final double expected = 7;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "2 + 4 + 1";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void subtractThreeNumbers() {
        final double expected = 4;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "10 - 4 - 2";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers() {
        final double expected = 45;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "9 * 5";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers() {
        final double expected = 7;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "42 / 6";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenTwoArithmeticOperationsDoneReturnsCorrectNumber() {
        final double expected = 28;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "49 + 7 / 2";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenInputEmptyReturnZero() {
        final double expected = 0;
        final double actual;
        classicCalculator = new ClassicCalculator();
        final String arithmeticExpression = "";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }
}
