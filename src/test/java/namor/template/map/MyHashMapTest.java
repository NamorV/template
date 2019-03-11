package namor.template.map;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHashMapTest {

    private MyHashMap<String, Integer> hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new MyHashMap<>();
    }

    @Test
    public void shouldReturnTrueWhenHashMapIsEmpty() {
        final boolean actual = hashMap.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void whenPutKeyAndValueIntoMapExpectMapIsEmptyFalse() {
        hashMap.put("King", 1);

        assertThat(hashMap.isEmpty()).isFalse();
    }

    @Test
    public void whenPutKeyAndValueIntoMapExpectStackSizeIncrements() {
        final int expected = 3;
        final int actual;

        hashMap.put("KING", 1);
        hashMap.put("BLAKE", 2);
        hashMap.put("CLARK", 3);
        actual = hashMap.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void pushedValueIsInTheStack()
    {
        final int expected = 3;
        final int actual;

        hashMap.put("KING", 3);
        actual = hashMap.get("KING");
        assertThat(actual).isEqualTo(expected);
    }
}
