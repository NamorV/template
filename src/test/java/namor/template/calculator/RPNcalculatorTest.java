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

    @Test(expected = IllegalArgumentException.class)
    public void ifInputStringIsNotCorrectThorwsException(){
        final String rpnString = "";

        rpnCalculato.isCorrect(rpnString);
    }
}