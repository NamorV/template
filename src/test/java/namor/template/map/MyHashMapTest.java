package namor.template.map;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHashMapTest {

    private MyHashMap<Integer, Integer> hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new MyHashMap<>();
    }

    @Test
    public void shouldReturnTrueWhenHashMapIsEmpty() {
        final boolean actual = hashMap.isEmpty();

        assertThat(actual).isTrue();
    }
}
