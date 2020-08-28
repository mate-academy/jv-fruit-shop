package core.basesyntax.services;

import core.basesyntax.ProductBox;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReportMakerServiceTest {
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final Storage testStorage = new Storage();
    public static final ProductBox product1 = new ProductBox("banana", 10,
            LocalDate.parse("2020-10-11", YYYY_MM_DD));
    public static final ProductBox product2 = new ProductBox("pear", 20,
            LocalDate.parse("2020-09-10", YYYY_MM_DD));

    @Test
    public void reportMakerServiceTestOk() {
        testStorage.getFruitSupplies().add(product1);
        testStorage.getFruitSupplies().add(product2);

        ReportMakerService reportMakerService = new ReportMakerService(testStorage);
        String result = reportMakerService.makeReport();
        Assert.assertEquals("fruit,quantity\rbanana,10\rpear,20\r", result);

        testStorage.getFruitSupplies().remove(product1);
        testStorage.getFruitSupplies().remove(product2);
    }

    @Test
    public void reportMakerServiceTestEmptyStorage() {
        ReportMakerService reportMakerService = new ReportMakerService(testStorage);
        String result = reportMakerService.makeReport();

        Assert.assertEquals("fruit,quantity\r", result);
    }

}