package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TransactionParserImplTest {
    private static TransactionParserImpl transactionParser = new TransactionParserImpl();

    @Test
    public void parse_ok() {
        List<String> lines = new ArrayList<>();
        lines.add("type,fruit,quantity");
        lines.add("b,banana,20");
        lines.add("p,banana,15");
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20));
        expected.add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 15));
        List<TransactionDto> actual = transactionParser.parse(lines);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void parse_notOk() {
        List<String> lines = new ArrayList<>();
        lines.add("b,5");
        new TransactionParserImpl().parse(lines);
    }
}
