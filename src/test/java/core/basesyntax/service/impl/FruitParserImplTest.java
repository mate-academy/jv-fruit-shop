package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class FruitParserImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", LocalDate.now());
    private static final FruitDto BANANA_DTO = new FruitDto("s", "banana", 100, LocalDate.now());
    private static final FruitDto KIWI_DTO = new FruitDto("s", "kiwi", 50, LocalDate.now());
    private static FruitMapper fruitParser;

    @BeforeClass
    public static void setup() {
        fruitParser = new FruitMapperImpl();
    }

    @Test
    public void parseFruitTest() {
        Fruit actual = fruitParser.parse(BANANA_DTO);
        Assert.assertEquals(BANANA_FRUIT, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void parseFruitNullTest() {
        fruitParser.parse(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void parseFruitWithEmptyListTest() {
        fruitParser.parse(null);
    }

    @Test
    public void equalsFruitsTest() {
        Fruit firstFruit = fruitParser.parse(BANANA_DTO);
        Fruit secondFruit = fruitParser.parse(BANANA_DTO);
        Assert.assertEquals(firstFruit, secondFruit);
    }

    @Test
    public void noEqualsFruitsTest() {
        Fruit firstFruit = fruitParser.parse(BANANA_DTO);
        Fruit secondFruit = fruitParser.parse(KIWI_DTO);
        Assert.assertNotEquals(firstFruit, secondFruit);
    }
}
