package core.basesyntax;

import core.basesyntax.exception.CsvFileException;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class LocalCsvFileReaderTest {
    private static final Transaction transactionOne
            = new Transaction(Operation.SUPPLY, "banana", 100, LocalDate.of(2020, 10, 17));
    private static final Transaction transactionTwo
            = new Transaction(Operation.BUY, "banana", 20, LocalDate.of(2020, 10, 15));
    private static final Transaction transactionThree
            = new Transaction(Operation.SUPPLY, "apple", 200, LocalDate.of(2020, 10, 17));
    private static final Transaction transactionFour
            = new Transaction(Operation.RETURN, "banana", 5, LocalDate.of(2020, 10, 17));
    private static final Transaction transactionFive
            = new Transaction(Operation.BUY, "apple", 50, LocalDate.of(2020, 10, 15));
    private static final String FILE_OK = "src/test/resources/test.csv";
    private static final String FILE_NOT_EXIST = "src/test/resources/not.exist";
    private static final String FILE_WRONG_CONTENT = "src/test/resources/wrong_content.csv";

    @Test
    public void readTransactions_OK() {
        CsvFileReader reader = new LocalCsvFileReader(FILE_OK);
        List<Transaction> actualList = reader.readTransactions();
        Assert.assertEquals(5, actualList.size());
        Assert.assertEquals(transactionOne, actualList.get(0));
        Assert.assertEquals(transactionTwo, actualList.get(1));
        Assert.assertEquals(transactionThree, actualList.get(2));
        Assert.assertEquals(transactionFour, actualList.get(3));
        Assert.assertEquals(transactionFive, actualList.get(4));
    }

    @Test
    public void readTransactions_notExist() {
        CsvFileReader reader = new LocalCsvFileReader(FILE_NOT_EXIST);
        try {
            reader.readTransactions();
            Assert.fail("Expect CsvFileException class");
        } catch (CsvFileException e) {
            Assert.assertEquals("File not found", e.getMessage());
        }
    }

    @Test(expected = RuntimeException.class)
    public void readTransactions_wrongContent() {
        CsvFileReader reader = new LocalCsvFileReader(FILE_WRONG_CONTENT);
        reader.readTransactions();
    }
}
