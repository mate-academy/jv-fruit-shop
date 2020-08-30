package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private static Reader reader;

    @BeforeClass
    public static void setReader() {
        reader = new Reader();
    }

    @Test(expected = RuntimeException.class)
    public void testWrongPath() {
        reader.readFromFile("src/resources/wrong.csv");
    }

    @Test
    public void testRightPass() {
        List<FruitDto> expected = new ArrayList<>();
        expected.add(new FruitDto("s", "banana", "100", "2020-10-17"));
        expected.add(new FruitDto("b", "banana", "50", "2020-10-16"));
        expected.add(new FruitDto("r", "banana", "35", "2020-10-17"));
        List<FruitDto> actual = reader.readFromFile("src/main/resources/Input.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void testWrongOperation() {
        reader.readFromFile("src/main/resources/WrongOperation.csv");
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectData() {
        reader.readFromFile("src/main/resources/IncorrectData.csv");
    }
}
