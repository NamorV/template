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
        final boolean actual = app.IsEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void checkIfPushedValueInStack() {
        final int expected = 4;
        app.push(4);

        assertThat(app.stack[0]).isEqualTo(expected);
    }

    @Test
    public void checkSizeMethod()
    {
        final int expected = 2;
        app.push(4);
        app.push(6);
        final int actual = app.stackSize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkThePopMethod()
    {
        app.push(4);
        app.push(6);
        app.pop();

        assertThat(app.stack[1]).isEqualTo(0);
    }

    @Test
    public void tryPeek()
    {
        final int expected = 4;
        app.push(4);
        final int actual = app.peak();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkIfStackIsResizable()
    {
        final int expected = 11;
        for (int i = 1; i < 12; i++)
        {
            app.push(11);
        }


        final int actual = app.stack[10];
        assertThat(actual).isEqualTo(expected);
    }
}
