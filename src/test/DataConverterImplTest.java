package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.DataConverterImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private final DataConverterImpl converter = new DataConverterImpl();

    @Test
    void convertToTransaction_validInput_ok() {
        List<String> input = List.of(
                "type,fruit,quantity",
                "b,banana,20",
                "p,apple,5");

        List<FruitTransaction> result = converter.convertToTransaction(input);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(FruitTransaction.Operation.BALANCE,
                result.get(0).getOperation());
        assertEquals("banana", result.get(0).getFruit());
        assertEquals(20, result.get(0).getQuantity());
    }

    @Test
    void convertToTransaction_inputWithSpaces_ok() {
        List<String> input = List.of(
                "type,fruit,quantity",
                " s , apple , 10");

        List<FruitTransaction> result = converter.convertToTransaction(input);

        assertEquals("apple", result.get(0).getFruit());
        assertEquals(10, result.get(0).getQuantity());
    }

    @Test
    void convertToTransaction_invalidFormat_notOk() {
        List<String> input = List.of("type,fruit,quantity", "b,banana");

        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));
    }

    @Test
    void convertToTransacton_NullLine_notOk() {
        List<String> input = new ArrayList<>();
        input.add("type,fruit,quantity");
        input.add(null);
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));
    }

    @Test
    void convertToTransaction_NullInput_notOk() {
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(null));
    }

    @Test
    void convertToTransaction_wrongColumnCount_notOk() {
        List<String> input = List.of(
                "type,fruit,quantity,xyz",
                " s , apple , 10,xyz");
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));

    }

    @Test
    void convertToTransaction_notNumber_notOk() {
        List<String> input = List.of(
                "type,fruit,quantity",
                " s , apple , Not_A_NUMBER");
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));

    }

    @Test
    void convertToTransaction_negativeQuantity_notOk() {
        List<String> input = List.of(
                "type,fruit,quantity",
                " s , apple , -50");
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));

    }

    @Test
    void convertToTransaction_wrongOperation_notOk() {
        List<String> input = List.of(
                "type,fruit,quantity",
                "z, apple , 50");
        assertThrows(RuntimeException.class,
                () -> converter.convertToTransaction(input));

    }
}
