package core.basesyntax.service.export.impl;

import core.basesyntax.ExportData;
import core.basesyntax.Fruit;
import core.basesyntax.Storage;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class ExportServiceImplTest {

    private Fruit banana;
    private Fruit bananaWithAnotherDate;
    private ExportServiceImpl service;

    @Before
    public void init() {
        banana = new Fruit(100, "banana", LocalDate.parse("2020-08-27"));
        bananaWithAnotherDate = new Fruit(200, "banana", LocalDate.parse("2020-08-26"));
        service = new ExportServiceImpl();
        Storage.fruits.clear();
    }

    @Test
    public void checkWithOneFruitInStorage() {
        Storage.fruits.add(banana);
        assertEquals(new ExportData(100, "banana"), service.prepareData().get(0));
    }

    @Test
    public void checkWithDifferentDate() {
        Storage.fruits.add(banana);
        Storage.fruits.add(bananaWithAnotherDate);
        assertEquals(new ExportData(300, "banana"), service.prepareData().get(0));
    }
}
