package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FruitParserImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", 100, LocalDate.now());
    private static final String TODAY_DATE_STRING = String.valueOf(LocalDate.now());
    private static FruitParser fruitParser;

    @BeforeClass
    public static void setup() {
        fruitParser = new FruitParserImpl();
    }

    @Test
    public void parseFruitTest() {
        Fruit actual = fruitParser.parse(List.of("s", "banana", "100", TODAY_DATE_STRING));
        Assert.assertEquals(BANANA_FRUIT, actual);
    }

    @Test(expected = NullPointerException.class)
    public void parseFruitNullTest() {
        fruitParser.parse(null);
    }

    @Test(expected = InvalidParameterException.class)
    public void parseFruitWithEmptyListTest() {
        fruitParser.parse(Collections.emptyList());
    }

    @Test(expected = InvalidParameterException.class)
    public void parseFruitWithWrongParametersTest() {
        fruitParser.parse(List.of("banana", "100", TODAY_DATE_STRING));
    }

    @Test
    public void equalsFruitsTest() {
        Fruit firstFruit = fruitParser.parse(List.of("s", "banana", "100", TODAY_DATE_STRING));
        Fruit secondFruit = fruitParser.parse(List.of("s", "banana", "100", TODAY_DATE_STRING));
        Assert.assertEquals(firstFruit, secondFruit);
    }

    @Test
    public void noEqualsFruitsTest() {
        Fruit firstFruit = fruitParser.parse(List.of("s", "banana", "100", TODAY_DATE_STRING));
        Fruit secondFruit = fruitParser.parse(List.of("s", "kiwi", "50", TODAY_DATE_STRING));
        Assert.assertNotEquals(firstFruit, secondFruit);
    }
}
