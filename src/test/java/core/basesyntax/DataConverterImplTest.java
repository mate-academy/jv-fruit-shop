package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private DataConverter dataConverter;

    @BeforeEach
    void setUp() {
        dataConverter = new DataConverterImpl();
    }

    @Test
    void convertValidData() {
        List<String> input = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,20",
                "s,apple,100"
        );

        List<FruitTransaction> transactions = dataConverter.convertToTransactions(input);
        assertEquals(2, transactions.size());

        FruitTransaction first = transactions.get(0);
        assertEquals(FruitTransaction.Operation.BALANCE, first.getOperation());
        assertEquals("banana", first.getFruit());
        assertEquals(20, first.getQuantity());
    }

    @Test
    void convertInvalidFormat() {
        List<String> input = Arrays.asList(
                "type,fruit,quantity",
                "b,banana" // Missing quantity
        );
        assertThrows(IllegalArgumentException.class,
                () -> dataConverter.convertToTransactions(input));
    }

    @Test
    void convertNegativeQuantity() {
        List<String> input = Arrays.asList(
                "type,fruit,quantity",
                "b,banana,-20" // Negative quantity
        );
        assertThrows(IllegalArgumentException.class,
                () -> dataConverter.convertToTransactions(input));
    }
}
