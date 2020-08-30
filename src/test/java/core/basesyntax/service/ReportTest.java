package core.basesyntax.service;

import core.basesyntax.Product;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReportTest {
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final Storage testStorage = new Storage();
    public static final Product product1 = new Product("banana", 10,
            LocalDate.parse("2020-10-11", YYYY_MM_DD));
    public static final Product product2 = new Product("pear", 20,
            LocalDate.parse("2020-09-10", YYYY_MM_DD));

    @Test
    public void reportMakerServiceTestOk() {
        testStorage.getFruitList().add(product1);
        testStorage.getFruitList().add(product2);

        Report report = new Report(testStorage);
        String result = report.makeReport();
        Assert.assertEquals("fruit,quantity\rbanana,10\rpear,20\r", result);

        testStorage.getFruitList().remove(product1);
        testStorage.getFruitList().remove(product2);
    }

    @Test
    public void reportMakerServiceTestEmptyStorage() {
        Report report = new Report(testStorage);
        String result = report.makeReport();

        Assert.assertEquals("fruit,quantity\r", result);
    }

}
