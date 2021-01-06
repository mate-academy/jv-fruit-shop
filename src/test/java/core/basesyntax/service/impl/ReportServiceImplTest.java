package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportServiceImplTest {

    private static ReportService reportService;

    @Before
    public void setUp() throws Exception {
        reportService = new ReportServiceImpl();
        Fruit melon = new Fruit("melon");
        Fruit cherry = new Fruit("cherry");
        Storage.fruitStorage.put(melon, 10);
        Storage.fruitStorage.put(melon, 20);
        Storage.fruitStorage.put(cherry, 50);
        Storage.fruitStorage.put(cherry, 30);
    }

    @Test
    public void invalidData() {
        List<String> fruitReport = reportService.createReport();
        Assert.assertNotEquals(fruitReport.get(0), "melon,60");
        Assert.assertNotEquals(fruitReport.get(1), "cherry,80");
        Assert.assertNotEquals(fruitReport.get(0), 456);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionData() {
        List<String> fruitReport = reportService.createReport();
        Assert.assertEquals(fruitReport.get(10), "melon,60");
    }
}
