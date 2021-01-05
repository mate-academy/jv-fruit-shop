package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DataReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvDataReaderImplTest {
    private static DataReader csvReader;
    private static final String correctFilePath = "src/test/resources/test-fruit.csv";
    private static final String incorrectFilePath = "src/test/test-fruit.csv";
    private static List<TransactionDto> expectedDtoList;

    @BeforeClass
    public static void beforeAll() {
        CsvParser csvParser = new CsvParser();
        csvReader = new CsvDataReaderImpl(csvParser);
        expectedDtoList = new ArrayList<>();
        TransactionDto testDto1 = new TransactionDto(Operation.fromString("b"),
                new Fruit("banana"), 20);
        TransactionDto testDto2 = new TransactionDto(Operation.fromString("s"),
                new Fruit("apple"), 100);
        expectedDtoList.add(testDto1);
        expectedDtoList.add(testDto2);
    }

    @Test
    public void readData_Ok() {
        assertEquals(expectedDtoList, csvReader.read(correctFilePath));
    }

    @Test(expected = RuntimeException.class)
    public void readData_NotOk() {
        csvReader.read(incorrectFilePath);
    }
}
