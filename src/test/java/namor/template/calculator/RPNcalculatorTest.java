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

        rpnCalculator.calculate(rpnString);
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

    @Test
    public void tryIfDivisionWorks(){
        final int expected = 7;
        final int actual;
        final String rpnString = "49 7 /";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkIfTwoOrMoreArithmaticOperatinsWorks(){
        final int expected = 11;
        final int actual;
        final String rpnString = "49 7 / 4 +";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSignAndNumberNotSeparetedThrowException(){
        final String rpnString = "4 3 + 2/";

        rpnCalculator.calculate(rpnString);
    }

}