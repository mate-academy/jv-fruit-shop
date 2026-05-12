package core.basesyntax.report;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {
    private Storage storage;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        storage = new ShopStorage();
        reportGenerator = new ReportGeneratorImpl(storage);
    }

    @Test
    void getReport_ShouldReturnCorrectFormat() {
        storage.create("banana", 100);
        storage.create("apple", 50);

        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,50" + System.lineSeparator()
                + "banana,100" + System.lineSeparator();
        
        assertEquals(expected, reportGenerator.getReport());
    }

    @Test
    void getReport_ShouldReturnEmptyReport_WhenStorageIsEmpty() {
        String expected = "fruit,quantity" + System.lineSeparator();
        assertEquals(expected, reportGenerator.getReport());
    }
}
