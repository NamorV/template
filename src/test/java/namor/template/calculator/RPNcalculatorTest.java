package namor.template.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RPNcalculatorTest {

    private RPNcalculator rpnCalculator;

    @Before
    public void setUp(){
        rpnCalculator = new RPNcalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifInputStringIsNotCorrectThorwsException(){
        final String rpnString = "";

        rpnCalculator.isCorrect(rpnString);
    }

    @Test
    public void tryIfAdditionWorks(){
        final int expected = 6;
        final int actual;
        final String rpnString = "2 4 +";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void tryIfSubstractionWorks(){
        final int expected = 5;
        final int actual;
        final String rpnString = "10 5 -";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void tryIfMultiplicationWorks(){
        final int expected = 45;
        final int actual;
        final String rpnString = "9 5 *";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }
}