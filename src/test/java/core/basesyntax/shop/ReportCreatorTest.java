package core.basesyntax.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReportCreatorTest {
    private static ReportCreator reportCreator;
    private static Fruit fruit;

    @BeforeAll
    static void beforeAll() {
        reportCreator = new ReportCreator();
        fruit = new Fruit("banana");
    }

    @Test
    void createReport_Ok() {
        Storage.fruits.put(fruit, 100);
        String expecct = "fruit,quantity\nbanana, 100\n";
        String actual = reportCreator.createReport();
        assertEquals(expecct, actual);
    }
}
