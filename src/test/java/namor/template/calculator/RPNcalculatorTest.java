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

    @Test
    public void addTwoNumbers(){
        final int expected = 6;
        final int actual;
        final String rpnString = "2 4 +";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void substactTwoNumbers(){
        final int expected = 5;
        final int actual;
        final String rpnString = "10 5 -";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers(){
        final int expected = 45;
        final int actual;
        final String rpnString = "9 5 *";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers(){
        final int expected = 7;
        final int actual;
        final String rpnString = "49 7 /";

        actual = rpnCalculator.calculate(rpnString);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenTwoArithmaticOperatinsDoneReurnsCorrectNumber(){
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