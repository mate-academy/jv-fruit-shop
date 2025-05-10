package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitDbTest {

    private FruitDB fruitDB;

    @BeforeEach
    void setUp() {
        fruitDB = new FruitDB();
    }

    @Test
    void testAdd() {
        // Act
        fruitDB.add("banana", 100);

        // Assert
        assertEquals(100, fruitDB.getInventory().get("banana"));
    }

    @Test
    void testSubtract() {
        // Arrange
        fruitDB.add("banana", 100);

        // Act
        fruitDB.subtract("banana", 50);

        // Assert
        assertEquals(50, fruitDB.getInventory().get("banana"));
    }

    @Test
    void testInventoryManagement() {
        // Act
        fruitDB.add("banana", 100);
        fruitDB.add("apple", 200);
        fruitDB.subtract("banana", 30);

        // Assert
        assertEquals(70, fruitDB.getInventory().get("banana"));
        assertEquals(200, fruitDB.getInventory().get("apple"));
    }
}
