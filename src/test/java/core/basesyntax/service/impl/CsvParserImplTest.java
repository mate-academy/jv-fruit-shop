package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvParserImplTest {
    private CsvParserImpl csvParser = new CsvParserImpl();
    private List<String> strings = new ArrayList<>();
    private Fruit apple = new Fruit();

    @Test
    public void correctCsvParserImpl() {
        strings.add("type,fruit,quantity");
        strings.add("b,apple,100");
        strings.add("b,banana,20");
        apple.setName("apple");
        List<TransactionDto> convert = csvParser.convert(strings);
        int actualAppleQuantity = convert.get(0).getQuantity();
        Fruit actualAppleFruit = convert.get(0).getFruit();
        Operation actualOperation = convert.get(0).getOperation();
        Assert.assertEquals(100, actualAppleQuantity);
        Assert.assertEquals(actualAppleFruit, apple);
        Assert.assertEquals(actualOperation, Operation.BALANCE);
    }

    @Test(expected = RuntimeException.class)
    public void incorrectCsvParserImpl() {
        strings.add("type,fruit,quantity");
        strings.add("b,banana,one");
        strings.add("b,banana,20");
        csvParser.convert(strings);
    }

    @Test(expected = RuntimeException.class)
    public void incorrectQuantityCsvParserImpl() {
        strings.add("type,fruit,quantity");
        strings.add("b,banana,-5");
        strings.add("b,banana,20");
        csvParser.convert(strings);
    }
}
