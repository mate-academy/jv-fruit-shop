package core.basesyntax.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.ItemTransaction;
import core.basesyntax.data.Operation;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterImpTest {
    private final Converter converter = new ConverterImpl();

    @Test
    void convert_ok() {
        List<String> input = new ArrayList<>();
        input.add("type,fruit,quantity");
        input.add("b,banana,20");
        input.add("b,apple,100");
        input.add("s,banana,100");
        input.add("p,banana,13");
        input.add("r,apple,10");
        input.add("p,apple,20");
        input.add("p,banana,5");
        input.add("s,banana,50");
        List<ItemTransaction> expected = new ArrayList<>();
        expected.add(new ItemTransaction(Operation.BALANCE,"banana", 20));
        expected.add(new ItemTransaction(Operation.BALANCE,"apple", 100));
        expected.add(new ItemTransaction(Operation.SUPPLY,"banana", 100));
        expected.add(new ItemTransaction(Operation.PURCHASE,"banana", 13));
        expected.add(new ItemTransaction(Operation.RETURN,"apple", 10));
        expected.add(new ItemTransaction(Operation.PURCHASE,"apple", 20));
        expected.add(new ItemTransaction(Operation.PURCHASE,"banana", 5));
        expected.add(new ItemTransaction(Operation.SUPPLY,"banana", 50));
        List<ItemTransaction> actual = converter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void convert_invalidData() {
        List<String> input1 = new ArrayList<>();
        input1.add("type,fruit,quantity");
        input1.add("b,banana20");
        assertThrows(RuntimeException.class, () ->
                converter.convert(input1));

        List<String> input2 = new ArrayList<>();
        input2.add("type,fruit,quantity");
        input2.add("b,banana,20,22");
        assertThrows(RuntimeException.class, () ->
                converter.convert(input2));

        List<String> input3 = new ArrayList<>();
        input3.add("type,fruit,quantity");
        input3.add("b,banana,asa");
        assertThrows(RuntimeException.class, () ->
                converter.convert(input3));

        List<String> input4 = new ArrayList<>();
        input4.add("type,fruit,quantity");
        input4.add("k,banana,20");
        assertThrows(RuntimeException.class, () ->
                converter.convert(input4));
    }

    @Test
    void convert_nullData() {
        List<String> input = new ArrayList<>();
        assertThrows(RuntimeException.class, () ->
                converter.convert(input));
    }

}
