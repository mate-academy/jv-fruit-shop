package core.basesyntax;

import core.basesyntax.fileservice.ReadFromFile;
import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.fruitservice.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadFromFileTest {
    private static ReadFromFile reader;
    private static FruitStorage fruitStorage;

    @BeforeClass
    public static void setup() {
        reader = new ReadFromFile();
        fruitStorage = new FruitStorage();
    }

    @Test
    public void normalDataTest() {
        List<Transaction> expected = new ArrayList<>();
        expected.add(Transaction.build("b", "banana","30","2020-10-25"));
        expected.add(Transaction.build("r", "banana","7","2020-12-10"));
        expected.add(Transaction.build("s", "mango","55","2020-12-10"));
        expected.add(Transaction.build("b", "mango","30","2020-10-23"));
        expected.add(Transaction.build("r", "banana","8","2020-12-10"));
        expected.add(Transaction.build("s", "blackberries","40","2020-11-15"));
        expected.add(Transaction.build("b", "blackberries","15","2020-10-23"));
        expected.add(Transaction.build("r", "blackberries","5","2020-12-10"));

        reader.readFromFile("src/main/resources/input.csv");
        Assert.assertEquals(expected, fruitStorage.getStorage());
    }

    @Test(expected = RuntimeException.class)
    public void wrongPath() {
        reader.readFromFile("src/main/resources/inputt.csv");
    }

    @AfterClass
    public static void Clear() {
        fruitStorage.getStorage().clear();
    }
}