package core.basesyntax;

import core.basesyntax.service.impl.ConvertToFruit;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ConvertToFruitTest {

    @Test
    public void convertTestOk() {
        ConvertToFruit converter = new ConvertToFruit();
        Fruit fruit = new Fruit();
        fruit.setName("banana");
        fruit.setDate(LocalDate.parse("2020-10-17"));
        FruitTransaction toConvert = new FruitTransaction("s",
                "banana",100, LocalDate.parse("2020-10-17"));
        Fruit actual = converter.convert(toConvert);
        Assert.assertEquals(fruit, actual);
    }
}
