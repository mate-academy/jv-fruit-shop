package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParseFruitImplTest {
    private static ParseFruit parseFruit;
    private static List<String[]> data;

    @BeforeClass
    public static void initialization() {
        parseFruit = new ParseFruitImpl();
        data = List.of(new String[]{"b", "banana", "100"},
                new String[]{"s", "apple", "20"},
                new String[]{"r", "banana", "50"});
    }

    @Test
    public void parse_correctValue_ok() {
        List<TransactionDto> currentTransactions = parseFruit.parse(data);
        Assert.assertEquals(3, currentTransactions.size());
        Assert.assertEquals(new TransactionDto(new Fruit("banana"),
                50, Operation.RETURN), currentTransactions.get(2));
    }

    @Test
    public void parse_emptyList_ok() {
        List<TransactionDto> currentTransactions = parseFruit.parse(List.of());
        Assert.assertTrue(currentTransactions.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void parse_nullValue_notOk() {
        List<TransactionDto> currentTransactions = parseFruit.parse(null);
    }

}
