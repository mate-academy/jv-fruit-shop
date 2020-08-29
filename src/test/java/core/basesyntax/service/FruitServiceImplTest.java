package core.basesyntax.service;


import core.basesyntax.model.Fruit;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FruitServiceImplTest {
    private FruitService fruitService;

    @Before
    public void init() {
        fruitService = new FruitServiceImpl();
    }

    @Test
    public void addWorksCorrectly() {
        fruitService.add(new Fruit("banana", LocalDate.parse("2020-10-17")));
        List<Fruit> actual = fruitService.getAll();
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", LocalDate.parse("2020-10-17")));

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithNullWorksCorrectly() {
        fruitService.add(null);
    }

    @Test
    public void sellWorksCorrectly() {
        fruitService.add(new Fruit("banana", LocalDate.parse("2020-10-17")));
        fruitService.add(new Fruit("orange", LocalDate.parse("2020-10-17")));
        fruitService.sell("banana", LocalDate.parse("2020-10-17"), 1);

        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("orange", LocalDate.parse("2020-10-17")));
        List<Fruit> actual = fruitService.getAll();

        assertEquals(expected, actual);
    }
}
