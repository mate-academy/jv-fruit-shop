package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class FruitParserImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", LocalDate.now());
    private static final List<FruitDto> BANANA_DTO = List.of(new FruitDto("s", "banana", 100, LocalDate.now()));
    private static final List<FruitDto> KIWI_DTO = List.of(new FruitDto("s", "kiwi", 50, LocalDate.now()));
    private static FruitParser fruitParser;

    @BeforeClass
    public static void setup() {
        fruitParser = new FruitParserImpl();
    }

    @Test
    public void parseFruitTest() {
        List<Fruit> actual = fruitParser.parse(BANANA_DTO);
        Assert.assertEquals(BANANA_FRUIT, actual.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void parseFruitNullTest() {
        fruitParser.parse(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void parseFruitWithEmptyListTest() {
        fruitParser.parse(Collections.emptyList());
    }

    @Test
    public void equalsFruitsTest() {
        List<Fruit> firstFruit = fruitParser.parse(BANANA_DTO);
        List<Fruit> secondFruit = fruitParser.parse(BANANA_DTO);
        Assert.assertEquals(firstFruit, secondFruit);
    }

    @Test
    public void noEqualsFruitsTest() {
        List<Fruit> firstFruit = fruitParser.parse(BANANA_DTO);
        List<Fruit> secondFruit = fruitParser.parse(KIWI_DTO);
        Assert.assertNotEquals(firstFruit, secondFruit);
    }
}
