package namor.template.main;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class AppTest {

    private App app;

    @Before
    public void setUp() throws Exception {
        app = new App(10);
    }

    @Test
    public void checkIfEmpty() {
        final boolean expected = true;
        final boolean actual = app.IsEmpty();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void tryPush() {
        final boolean expected = false;
        app.push(4);
        app.push(6);
        final boolean actual = app.IsEmpty();

        assertThat(actual).isEqualTo(expected);
    }
}
