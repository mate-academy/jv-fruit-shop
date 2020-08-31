package core.basesyntax;

import core.basesyntax.Fruit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitTest {
   static Fruit fruit = new Fruit("banana","2020-10-15");

    @Test
    public void getTypeOfFruit() {
        Assert.assertEquals("banana", fruit.getTypeOfFruit());
    }

    @Test
    public void getExpirationDate() {
        Assert.assertEquals("2020-10-15", fruit.getExpirationDate());
    }

    @Test
    public void testEquals() {
        Fruit fruitTheSame = new Fruit("banana","2020-10-15");
        Assert.assertEquals(true, fruitTheSame.equals(fruit));
    }
}