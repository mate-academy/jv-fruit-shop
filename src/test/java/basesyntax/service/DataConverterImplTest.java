package basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import basesyntax.model.FruitTransaction;
import basesyntax.service.impl.DataConverterImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private DataConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DataConverterImpl();
    }

    @Test
    void convert_validData_ok() {
        List<String> input = List.of("b,banana,20");

        List<FruitTransaction> result = converter.convertToTransaction(input);

        assertEquals(1, result.size());
        assertEquals("banana", result.get(0).getFruit());
        assertEquals(20, result.get(0).getQuantity());
    }
}
