package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private final DataConverter converter = new DataConverterImpl();

    @Test
    void emptyList_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            converter.convertToTransaction(Collections.emptyList());
        });
    }

    @Test
    void wrongSizeList_NotOk() {
        List<String> listTest = List.of("b,watermelon,123,2", "s,peach,12,2");
        assertThrows(RuntimeException.class, () -> {
            converter.convertToTransaction(listTest);
        });
    }
}
