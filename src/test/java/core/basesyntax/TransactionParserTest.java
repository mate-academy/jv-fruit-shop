package core.basesyntax;

import core.basesyntax.fileservice.ReadFile;
import core.basesyntax.fileservice.TransactionParser;
import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.fruitservice.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TransactionParserTest {
    private static TransactionParser transactionParser;
    private static List<Transaction> transactions;
    private static ReadFile readFile;

    @BeforeClass
    public static void setup() {
        transactionParser = new TransactionParser();
        transactions = new ArrayList<>();
        readFile = new ReadFile();
    }

    @Test
    public void normalDataTest() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction("b", "banana","30","2020-10-25"));
        expected.add(new Transaction("r", "banana","7","2020-12-10"));
        expected.add(new Transaction("s", "mango","55","2020-12-10"));
        expected.add(new Transaction("b", "mango","30","2020-10-23"));
        expected.add(new Transaction("r", "banana","8","2020-12-10"));
        expected.add(new Transaction("s", "blackberries","40","2020-11-15"));
        expected.add(new Transaction("b", "blackberries","15","2020-10-23"));
        expected.add(new Transaction("r", "blackberries","5","2020-12-10"));
        transactions.addAll(transactionParser.parseDate(readFile.read("src/test/resources/input.csv")));
        Assert.assertEquals(expected, transactions);
    }
}
