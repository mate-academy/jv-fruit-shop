package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.impl.CsvParserImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
    private static List<String> data = new ArrayList<>();

    @Before
    public void beforeClass() {
        data.add("type,fruit,quantity");
        data.add("b,banana,100");
    }

    @Test
    public void parse_OK() {
        List<TransactionDto> actual = new CsvParserImpl().parse(data);
        Assert.assertSame(TransactionDto.class, actual.get(0).getClass());
        Assert.assertSame(Operation.BALANCE, actual.get(0).getOperation());
        Assert.assertEquals("banana", actual.get(0).getFruit().getName());
        Assert.assertEquals(Integer.valueOf(100), actual.get(0).getQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void parse_NotOk() {
        data.add("type,fruit,quantity");
        data.add("b,banana,-100");
        new CsvParserImpl().parse(data);
    }

    @After
    public void tearDown() {
        data.clear();
    }
}
