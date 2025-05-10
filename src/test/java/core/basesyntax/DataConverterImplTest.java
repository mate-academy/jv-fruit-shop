package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private final DataConverter converter = new DataConverterImpl();

    @Test
    void emptyList_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            converter.convertToTransaction(Collections.emptyList());
        });
    }
}
