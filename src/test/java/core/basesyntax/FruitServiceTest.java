package core.basesyntax;

import core.basesyntax.model.FruitBox;
import core.basesyntax.service.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitServiceTest {
    private FruitFileReader reader = new FruitFileReader();
    private FruitService service = new FruitService();

    @Test(expected = RuntimeException.class)
    public void testWrongOperation() {
        service.parseOperations(reader.readFruitFile("src/WrongOperation.csv"));
    }

    @Test
    public void testEmptyLine() {
        List<Operation> actual = service.parseOperations(reader.readFruitFile("src/EmptyLine.csv"));
        List<Operation> expected = new ArrayList<>();
        expected.add(new Supply(OperationType.SUPPLY, new FruitBox("banana", 100, LocalDate.parse("2020-10-17"), false)));
        expected.add(new Return(OperationType.RETURN, new FruitBox("banana", 10, LocalDate.parse("2020-10-17"), false)));
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectData() {
        service.parseOperations(reader.readFruitFile("src/IncorrectData.csv"));
    }

}
