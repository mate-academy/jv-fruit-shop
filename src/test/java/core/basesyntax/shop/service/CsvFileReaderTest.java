package core.basesyntax.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileReaderTest {
    public static final String DAY_ACTIVITY = "src/test/resources/NormalDayActivity.csv";
    public static final String BROKEN_FILE_1 = "src/test/resources/BrokenDayActivity1.csv";
    public static final String BROKEN_FILE_2 = "src/test/resources/BrokenDayActivity2.csv";
    public static final String BROKEN_FILE_3 = "src/test/resources/BrokenDayActivity3.csv";
    public static final String WRONG_FILE_1 = "src/test/resources/WrongDayActivity1.csv";
    public static final String WRONG_FILE_2 = "src/test/resources/WrongDayActivity2.csv";
    public static final String MISSING_FILE = "src/test/resources/MissingFile.csv";

    private static FileReader reader;
    private static List<TransactionDto> expectedTransactionDtos;

    @BeforeAll
    public static void beforeAll() {
        reader = new CsvFileReader();
        expectedTransactionDtos = new ArrayList<>();
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("apple"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 13));
        expectedTransactionDtos.add(new TransactionDto(Operation.RETURN,
                new Fruit("apple"), 10));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("apple"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 5));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 50));
    }

    @Test
    public void readData_FromNormalFile() {
        List<TransactionDto> actualTransactionDtos = reader.readData(DAY_ACTIVITY);
        for (int i = 0; i < actualTransactionDtos.size(); i++) {
            assertEquals(expectedTransactionDtos.get(i).getOperation(),
                    actualTransactionDtos.get(i).getOperation());
            assertEquals(expectedTransactionDtos.get(i).getFruit(),
                    actualTransactionDtos.get(i).getFruit());
            assertEquals(expectedTransactionDtos.get(i).getQuantity(),
                    actualTransactionDtos.get(i).getQuantity());
        }
    }

    @Test
    public void readData_FromBrokenFile() {
        assertThrows(IllegalArgumentException.class, () -> reader.readData(BROKEN_FILE_1));
        assertThrows(IllegalArgumentException.class, () -> reader.readData(BROKEN_FILE_2));
        assertThrows(IllegalArgumentException.class, () -> reader.readData(BROKEN_FILE_3));
    }

    @Test
    public void readData_FromWrongFile() {
        assertThrows(RuntimeException.class, () -> reader.readData(WRONG_FILE_1));
        assertThrows(RuntimeException.class, () -> reader.readData(WRONG_FILE_2));
        assertThrows(RuntimeException.class, () -> reader.readData(MISSING_FILE));
    }
}
