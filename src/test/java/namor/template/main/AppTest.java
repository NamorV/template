package namor.template.main;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class AppTest {

    private App app;

    @Before
    public void setUp() throws Exception {
        app = new App();
    }

    @Test
    public void addTwoNumbers() {
        final int expected = 4;
        final int actual = app.add(2, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void subtractTwoNumbers() {
        final int expected = 2;
        final int actual = app.substract( 7, 5);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplicateTwoNumbers() {
        final int expected = 15;
        final int actual = app.multiplicate( 3, 5);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divideTwoNumbers() {
        final int expected = 7;
        final int actual = app.devide( 21, 3);

        assertThat(actual).isEqualTo(expected);
    }
}