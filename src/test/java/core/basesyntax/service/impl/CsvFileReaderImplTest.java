package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderImplTest {
    public static CsvFileReaderImpl csvFileReader;
    public static List<TransactionDto> expected;

    @BeforeClass
    public static void beforeClass() throws Exception {
        csvFileReader = new CsvFileReaderImpl();
        expected = new ArrayList<>();
    }

    @Test
    public void readData_method_Ok() {
        Fruit fruit = new Fruit("apple");
        TransactionDto transactionDto = new TransactionDto(Operation.BALANCE, fruit, 100);
        transactionDto.setFruit(fruit);
        transactionDto.setOperation(Operation.BALANCE);
        transactionDto.setCount(100);
        expected.add(transactionDto);
        String filePath = "src/test/resources/read-data.txt";
        assertEquals(expected.get(0).getOperation(),
                csvFileReader.readData(filePath).get(0).getOperation());
        assertEquals(expected.get(0).getCount(),
                csvFileReader.readData(filePath).get(0).getCount());
        assertEquals(expected.get(0).getFruit().getName(),
                csvFileReader.readData(filePath).get(0).getFruit().getName());
    }

    @Test(expected = RuntimeException.class)
    public void incorrect_filename_Exception_Ok() {
        csvFileReader.readData("incorrectFileName");
    }
}
