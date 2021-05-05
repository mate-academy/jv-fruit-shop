package core.basesyntax.shop.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.shop.Fruit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringSplitterTest {
    private static StringSplitter splitter;
    private static StringSplitter incorrectSplitter =
            new StringSplitter("z,banana,i10");
    private static final String SPLIT_LINE = "s,banana,100";

    @BeforeAll
    static void beforeAll() {
        splitter = new StringSplitter(SPLIT_LINE);
    }

    @Test
    void getCount_Ok() {
        int expected = 100;
        int actual = splitter.getCount();
        assertEquals(expected, actual);
    }

    @Test
    void getCount_NotOk() {
        assertThrows(RuntimeException.class,
                () -> incorrectSplitter.getCount());

    }

    @Test
    void getFruit_Ok() {
        assertEquals(new Fruit("banana"), splitter.getFruit());
    }

    @Test
    void getFruit_NotOk() {
        assertNotEquals(new Fruit("cucumber"), splitter.getFruit());
    }

    @Test
    void getTypeOfOperation_Ok() {
        String expected = "S";
        String actual = splitter.getTypeOfOperation();
        assertEquals(expected, actual);
    }

    @Test
    void getTypeOfOperation_NotOk() {
        assertThrows(RuntimeException.class,
                () -> incorrectSplitter.getTypeOfOperation());
    }
}
