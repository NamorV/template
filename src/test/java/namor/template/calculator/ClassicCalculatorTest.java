package namor.template.calculator;

import namor.template.stack.ArrayStack;
import namor.template.stack.MapBasedStack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicCalculatorTest {

    private ClassicCalculator classicCalculator;

    @Test
    public void addTwoNumbers() {
        final double expected = 6.4;
        final double actual;
        classicCalculator = new ClassicCalculator(new ArrayStack<Double>());
        final String arithmeticExpression = "2.1 4.3 +";

        actual = classicCalculator.calculate(arithmeticExpression);
        assertThat(actual).isEqualTo(expected);
    }
}
