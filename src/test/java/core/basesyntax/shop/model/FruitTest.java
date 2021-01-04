package core.basesyntax.shop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitTest {
    private static Fruit apple;
    private static Fruit banana;
    private static Fruit anotherApple;
    private static Fruit anotherBanana;
    private static Fruit nullFruit;

    @BeforeAll
    public static void beforeAll() {
        apple = new Fruit("apple");
        banana = new Fruit("banana");
        anotherApple = new Fruit("apple");
        anotherBanana = new Fruit("banana");
        nullFruit = null;
    }

    @Test
    public void getType() {
        assertEquals("apple", apple.getType());
        assertEquals("banana", banana.getType());
        assertEquals("apple", anotherApple.getType());
        assertEquals("banana", anotherBanana.getType());
    }

    @Test
    public void testEquals() {
        assertEquals(apple, apple);
        assertEquals(anotherApple, apple);
        assertEquals(banana, anotherBanana);
        assertNotEquals(apple, banana);
        assertNotEquals(apple, anotherBanana);
        assertNotEquals(anotherApple, banana);
        assertNotEquals(anotherApple, anotherBanana);
        assertNotEquals(apple, nullFruit);
        assertNotEquals(banana, nullFruit);
    }

    @Test
    public void testHashCode() {
        assertEquals(anotherApple.hashCode(), apple.hashCode());
        assertEquals(banana.hashCode(), anotherBanana.hashCode());
        assertNotEquals(apple.hashCode(), banana.hashCode());
        assertNotEquals(apple.hashCode(), anotherBanana.hashCode());
    }
}
