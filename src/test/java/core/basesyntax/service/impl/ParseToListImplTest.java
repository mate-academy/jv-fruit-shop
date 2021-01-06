package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParseToList;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParseToListImplTest {
    private static List<TransactionDto> data = new ArrayList<>();
    private static List<String> listOfStringsWithOneLine = new ArrayList<>();
    private static List<String> listOfStringsWithThreeLines = new ArrayList<>();
    private static List<String> nullList;
    private static ParseToList parseToList = new ParseToListImpl();

    @BeforeClass
    public static void setUp() {
        listOfStringsWithOneLine.add("b,banana,150");
        listOfStringsWithThreeLines.add("b,banana,20");
        listOfStringsWithThreeLines.add("b,apple,100");
        listOfStringsWithThreeLines.add("s,orange,60");
    }

    @After
    public void data() {
        if (data != null) {
            data.clear();
        }
    }

    @Test
    public void parseOneLine_Ok() {
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 150));
        List<TransactionDto> actual = parseToList.parseToTransactions(listOfStringsWithOneLine);
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseThreeLines_Ok() {
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20));
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100));
        expected.add(new TransactionDto(Operation.SUPPLY, new Fruit("orange"), 60));
        List<TransactionDto> actual = parseToList.parseToTransactions(listOfStringsWithThreeLines);
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void noDataInFile() {
        parseToList.parseToTransactions(nullList);
    }
}
