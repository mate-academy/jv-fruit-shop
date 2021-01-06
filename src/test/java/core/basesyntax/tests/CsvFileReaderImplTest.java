package core.basesyntax.tests;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderImplTest {
    private static final String CORRECT_BALANCE = "src/test/resources/example_TestOK.csv";
    private static final String MISSING_FILE = "src/test/resources/example_Missed";
    private static final String MISTAKE_IN_ROW1 = "src/test/resources/example_NotOKFirstRow";
    private static final String MISTAKE_IN_ROW2 = "src/test/resources/example_NotOKSecondRow";
    private static final String MISTAKE_IN_ROW3 = "src/test/resources/example_NotOKThirdRow";
    private static final String WRONG_OPERATOR = "src/test/resources/example_WrongOperator";
    private static final String INCORRECT_DATA_FORMAT = "src/test/resources/"
            + "example_WrongInputAtAll";

    private static DataReader dataReader;
    private static List<Transaction> expectedBalance;

    @BeforeClass
    public static void beforeClass() {
        dataReader = new CsvFileReaderImpl();
        expectedBalance = new ArrayList<>();
        expectedBalance.add(new Transaction(Operations.BALANCE, new Fruit("banana"), 20));
        expectedBalance.add(new Transaction(Operations.BALANCE, new Fruit("kiwi"), 100));
        expectedBalance.add(new Transaction(Operations.SUPPLY, new Fruit("banana"), 100));
        expectedBalance.add(new Transaction(Operations.PURCHASE, new Fruit("banana"), 13));
        expectedBalance.add(new Transaction(Operations.RETURN, new Fruit("apple"), 10));
        expectedBalance.add(new Transaction(Operations.PURCHASE, new Fruit("kiwi"), 100));
        expectedBalance.add(new Transaction(Operations.PURCHASE, new Fruit("banana"), 26));
        expectedBalance.add(new Transaction(Operations.SUPPLY, new Fruit("apple"), 50));
    }

    @Test
    public void readFile_OK() {
        List<Transaction> actual = dataReader.read(CORRECT_BALANCE);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expectedBalance.get(i).getOperation(), actual.get(i).getOperation());
            assertEquals(expectedBalance.get(i).getFruitName(), actual.get(i).getFruitName());
            assertEquals(expectedBalance.get(i).getAmount(), actual.get(i).getAmount());
        }
    }

    @Test(expected = RuntimeException.class)
    public void readMissingFile_NotOK() {
        dataReader.read(MISSING_FILE);
    }

    @Test(expected = RuntimeException.class)
    public void readNotCorrectInformationFromRow1_NotOK() {
        dataReader.read(MISTAKE_IN_ROW1);
    }

    @Test(expected = RuntimeException.class)
    public void readNotCorrectInformationFromRow2_NotOK() {
        dataReader.read(MISTAKE_IN_ROW2);
    }

    @Test(expected = RuntimeException.class)
    public void readNotCorrectInformationFromRow3_NotOK() {
        dataReader.read(MISTAKE_IN_ROW3);
    }

    @Test(expected = RuntimeException.class)
    public void readNotCorrectOperatorFromFile_NotOK() {
        dataReader.read(WRONG_OPERATOR);
    }

    @Test(expected = RuntimeException.class)
    public void readNotCorrectInformationFromFile_NotOK() {
        dataReader.read(INCORRECT_DATA_FORMAT);
    }
}
