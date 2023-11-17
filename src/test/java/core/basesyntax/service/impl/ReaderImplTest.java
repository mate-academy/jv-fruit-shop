package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.Reader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReaderImplTest {
    private final Reader reader = new ReaderImpl();

    @Test
    void read_ok() {
        String fileName = "src/main/resources/input.csv";
        List<String> expected = new ArrayList<>();
        expected.add("type,fruit,quantity");
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("r,apple,10");
        expected.add("p,apple,20");
        expected.add("p,banana,5");
        expected.add("s,banana,50");

        List<String> actual = reader.read(fileName);
        assertEquals(expected, actual);
    }

    @Test
    void read_invalidFileName() {
        assertThrows(RuntimeException.class, () ->
                reader.read("nu%$#lllllll"));
    }

    @Test
    void read_nullFileName() {
        assertThrows(RuntimeException.class, () ->
                reader.read(null));
    }
}
