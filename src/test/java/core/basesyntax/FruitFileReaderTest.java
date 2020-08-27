package core.basesyntax;

import core.basesyntax.model.FruitBox;
import core.basesyntax.service.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReaderTest {
    FruitFileReader reader = new FruitFileReader();

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        reader.readOperation("src/Tes4t.csv");
    }

    @Test
    public void testRightPath() {
        List<Operation> actual = reader.readOperation("src/PerfectData.csv");
        List<Operation> expected = new ArrayList<>();
        expected.add(new Supply(OperationType.SUPPLY, new FruitBox("banana", 100, LocalDate.parse("2020-10-17"), false)));
        expected.add(new Buy(OperationType.BUY, new FruitBox("banana", 13, LocalDate.parse("2020-10-16"), false)));
        expected.add(new Return(OperationType.RETURN, new FruitBox("banana", 10, LocalDate.parse("2020-10-17"), false)));
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = RuntimeException.class)
    public void testWrongOperation() {
        reader.readOperation("src/WrongOperation.csv");
    }

    @Test
    public void testEmptyLine() {
        List<Operation> actual = reader.readOperation("src/EmptyLine.csv");
        List<Operation> expected = new ArrayList<>();
        expected.add(new Supply(OperationType.SUPPLY, new FruitBox("banana", 100, LocalDate.parse("2020-10-17"), false)));
        expected.add(new Return(OperationType.RETURN, new FruitBox("banana", 10, LocalDate.parse("2020-10-17"), false)));
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectData() {
        reader.readOperation("src/IncorrectData.csv");
    }
}
