package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.exceptions.NegativeQuantityException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvParserTest {
    private static CsvParser csvParser;
    private static final String TEST_STRING_1 = "b,banana,20";
    private static final String TEST_STRING_2 = "s,apple,100";
    private static final String TEST_STRING_3 = "b,apple,-100";
    private static List<TransactionDto> expectedDtoList;
    private static List<String> inputOkStringList;
    private static List<String> inputNotOkStringList;
    private static final TransactionDto testDto1 = new TransactionDto(Operation.fromString("b"),
            new Fruit("banana"), 20);
    private static final TransactionDto testDto2 = new TransactionDto(Operation.fromString("s"),
            new Fruit("apple"), 100);

    @BeforeClass
    public static void beforeAll() {
        csvParser = new CsvParser();
        inputOkStringList = new ArrayList<>();
        inputNotOkStringList = new ArrayList<>();
        inputOkStringList.add(TEST_STRING_1);
        inputOkStringList.add(TEST_STRING_2);
        inputNotOkStringList.add(TEST_STRING_3);
        expectedDtoList = new ArrayList<>();
        TransactionDto testDto1 = new TransactionDto(Operation.fromString("b"),
                new Fruit("banana"), 20);
        TransactionDto testDto2 = new TransactionDto(Operation.fromString("s"),
                new Fruit("apple"), 100);
        expectedDtoList.add(testDto1);
        expectedDtoList.add(testDto2);
    }

    @Test
    public void parseString_Ok() {
        assertEquals(expectedDtoList, csvParser.parse(inputOkStringList));
    }

    @Test(expected = NegativeQuantityException.class)
    public void parseString_NotOk() {
        csvParser.parse(inputNotOkStringList);
    }
}
