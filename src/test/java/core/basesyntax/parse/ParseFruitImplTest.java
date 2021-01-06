package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParseFruitImplTest {
    private static DataParser parseFruit;
    private static List<String[]> data;

    @BeforeClass
    public static void initialization() {
        parseFruit = new FruitParserImpl();
        data = List.of(new String[]{"b", "banana", "100"},
                new String[]{"s", "apple", "20"},
                new String[]{"r", "banana", "50"});
    }

    @Test
    public void parse_correctValue_ok() {
        List<TransactionDto> currentTransactions = parseFruit.parse(data);
        Assert.assertEquals(3, currentTransactions.size());
        Assert.assertEquals(new TransactionDto(new Fruit("banana"),
                100, Operation.BALANCE), currentTransactions.get(0));
        Assert.assertEquals(new TransactionDto(new Fruit("apple"),
                20, Operation.SUPPLY), currentTransactions.get(1));
        Assert.assertEquals(new TransactionDto(new Fruit("banana"),
                50, Operation.RETURN), currentTransactions.get(2));
    }

    @Test
    public void parse_emptyList_ok() {
        List<TransactionDto> currentTransactions = parseFruit.parse(Collections.emptyList());
        Assert.assertTrue(currentTransactions.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void parse_nullValue_notOk() {
        List<TransactionDto> currentTransactions = parseFruit.parse(null);
    }

}
