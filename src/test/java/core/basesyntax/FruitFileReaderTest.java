package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReaderTest {
    private static FruitFileReader reader;

    @BeforeClass
    public static void setReader() {
        reader = new FruitFileReader();
    }

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        reader.readOperation("src/resources/wrong.csv");
    }

    @Test
    public void testRightPath() {
        List<FruitOperation> actual = reader.readOperation("src/main/resources/Input.csv");
        List<FruitOperation> expected = new ArrayList<>();
        expected.add(new SupplyFruitOperation(OperationType.SUPPLY, new Transaction("banana", 100, LocalDate.parse("2020-10-17"), false)));
        expected.add(new BuyFruitOperation(OperationType.BUY, new Transaction("banana", 13, LocalDate.parse("2020-10-16"), false)));
        expected.add(new ReturnFruitOperation(OperationType.RETURN, new Transaction("banana", 10, LocalDate.parse("2020-10-17"), false)));
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = RuntimeException.class)
    public void testWrongOperation() {
        reader.readOperation("src/main/resources/WrongOperation.csv");
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectData() {
        reader.readOperation("src/main/resources/IncorrectData.csv");
    }
}
