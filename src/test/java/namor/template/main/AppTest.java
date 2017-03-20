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
}
