package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parse;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParseCsvImplTest {
    private static Parse parseCsv;
    private static List<String> dataForParse;
    private static List<String> notValidDataForParse;

    @BeforeClass
    public static void beforeClass() {
        parseCsv = new ParseCsvImpl();
        dataForParse = Arrays.asList("b,banana,20", "b,apple,100");
        notValidDataForParse = Arrays.asList("b,banana,20,20", "b,apple,100,s");
    }

    @Test
    public void parseUsualData_Ok() {
        List<TransactionDto> expected = Arrays.asList(
                new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100));
        List<TransactionDto> actual = parseCsv.parse(dataForParse);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNotValidData_NotOk() {
        parseCsv.parse(notValidDataForParse);
    }
}
