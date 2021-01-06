package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportServiceImplTest {

    private static ReportService reportService;
    private static List<String> testReport;
    private static Map<Fruit, Integer> fruits;

    @Before
    public void setUp() throws Exception {
        reportService = new ReportServiceImpl();
    }

    @Test
    public void createReport() {
        testReport = new ArrayList<>();
        testReport.add("banana,20");
        Storage.fruitStorage.put(new Fruit("banana"), 12);
        Storage.fruitStorage.put(new Fruit("mango"), 5);
        List<String> actual = reportService.createReport();
        List<String> expected = List.of("banana,12", "mango,5");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void invalidData() {
        Fruit melon = new Fruit("melon");
        Fruit cherry = new Fruit("cherry");
        Storage.fruitStorage.put(melon, 10);
        Storage.fruitStorage.put(melon, 20);
        Storage.fruitStorage.put(cherry, 50);
        Storage.fruitStorage.put(cherry, 30);
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

    @After
    public void clean() {
        Storage.fruitStorage.clear();
    }
}
