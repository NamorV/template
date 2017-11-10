package namor.template.calculator;

import namor.template.stack.ArrayStack;
import namor.template.stack.MapBasedStack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicCalculatorTest {

    private ClassicCalculator classicCalculator;

    @Test
    public void addTwoNumbers() {
        final double expected = 7;
        final double actual;
        classicCalculator = new ClassicCalculator(new ArrayStack());
        final String arithmeticExpression = "2 + 4 + 1";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void subtractTwoNumbers() {
        final double expected = 4;
        final double actual;
        classicCalculator = new ClassicCalculator(new ArrayStack());
        final String arithmeticExpression = "10 - 4 - 2";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers() {
        final double expected = 45;
        final double actual;
        classicCalculator = new ClassicCalculator(new ArrayStack<Long>());
        final String arithmeticExpression = "9 * 5";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers() {
        final double expected = 7;
        final double actual;
        classicCalculator = new ClassicCalculator(new ArrayStack<Integer>());
        final String arithmeticExpression = "42 6 /";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }
}
