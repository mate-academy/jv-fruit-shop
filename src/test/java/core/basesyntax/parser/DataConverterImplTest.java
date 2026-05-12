package core.basesyntax.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exception.DataProcessingException;
import core.basesyntax.strategy.handler.Operation;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {

    private DataConverterImpl converter;

    @BeforeEach
    void setUp() {
        converter = new DataConverterImpl();
    }

    @Test
    void convert_ShouldParseSingleLine() {
        Stream<String> input = Stream.of("b,apple,10");
        List<FruitTransaction> result = converter.convertToTransaction(input).toList();

        assertEquals(1, result.size());

        FruitTransaction tx = result.get(0);
        assertEquals(Operation.BALANCE, tx.getOperation());
        assertEquals("apple", tx.getFruit());
        assertEquals(10, tx.getQuantity());
    }

    @Test
    void convert_ShouldSkipHeader() {
        Stream<String> input = Stream.of(
                "type,fruit,quantity",
                "b,apple,10"
        );
        List<FruitTransaction> result = converter.convertToTransaction(input).toList();
        assertEquals(1, result.size());
    }

    @Test
    void convert_ShouldSkipHeader_IgnoringCase() {
        Stream<String> input = Stream.of(
                "TyPe,fruit,quantity",
                "b,apple,10"
        );
        List<FruitTransaction> result = converter.convertToTransaction(input).toList();
        assertEquals(1, result.size());
    }

    @Test
    void convert_ShouldTrimValues() {
        Stream<String> input = Stream.of("  b  ,  apple  ,  10  ");
        List<FruitTransaction> result = converter.convertToTransaction(input).toList();
        FruitTransaction tx = result.get(0);

        assertEquals(Operation.BALANCE, tx.getOperation());
        assertEquals("apple", tx.getFruit());
        assertEquals(10, tx.getQuantity());
    }

    @Test
    void convert_ShouldThrowException_WhenQuantityInvalid() {
        Stream<String> input = Stream.of("b,apple,ten");
        assertThrows(DataProcessingException.class, () -> 
                converter.convertToTransaction(input).toList());
    }

    @Test
    void convert_ShouldThrowException_WhenColumnsMissing() {
        Stream<String> input = Stream.of("b,apple");
        assertThrows(DataProcessingException.class, () -> 
                converter.convertToTransaction(input).toList());
    }
}
