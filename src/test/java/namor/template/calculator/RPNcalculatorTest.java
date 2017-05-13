package namor.template.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RPNcalculatorTest {

    private RPNcalculator rpnCalculato;

    @Before
    public void setUp(){
        rpnCalculato = new RPNcalculator();
    }

    @Test
    public void ifStringIsCorrectShouldReturnTrue(){
        final String rpnString = "2 4 + =";
        final boolean result;

        result = rpnCalculato.IsCorrect(rpnString);
        assertThat(result).isTrue();
    }

    @Test
    public void ifStringIsNotCorrectShouldReturnFalse(){
        final String rpnString = "2 x + =";
        final boolean result;

        result = rpnCalculato.IsCorrect(rpnString);
        assertThat(result).isFalse();
    }
}