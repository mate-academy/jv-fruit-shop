package core.basesyntax;

import core.basesyntax.service.impl.ConvertToFruit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class ConvertToFruitTest {
    private static ConvertToFruit converter = new ConvertToFruit();
    private static Fruit FRUIT_EXPECTED;

    @BeforeClass
    public static void createExpectedFruit() {
        FRUIT_EXPECTED = new Fruit();
        FRUIT_EXPECTED.setName("banana");
        FRUIT_EXPECTED.setDate(LocalDate.parse("2020-10-17"));
    }

    @Test
    public void convertTestOk() {
        FruitTransaction toConvert = new FruitTransaction("s","banana",100, LocalDate.parse("2020-10-17"));
        Fruit actual = converter.convert(toConvert);
        Assert.assertEquals(FRUIT_EXPECTED, actual);
    }
}