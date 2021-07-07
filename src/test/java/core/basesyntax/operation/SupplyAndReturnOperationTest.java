package core.basesyntax.operation;

import core.basesyntax.service.Record;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SupplyAndReturnOperationTest {
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final Storage testStorage = new Storage();
    public static final Record testRecordIncome = new Record("s", "pineapple",
            "10", "2020-08-26");
    public static final Record testRecordIncome2 = new Record("r", "pineapple",
            "100", "2020-08-26");
    @Test
    public void incomeShopOperationTestOk() {
        LocalDate date = LocalDate.parse("2020-08-26", YYYY_MM_DD);

        SupplyAndReturnOperation incomeShopOperation = new SupplyAndReturnOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        Assert.assertEquals("pineapple", testStorage.getFruitList().get(0).getProductName());
        Assert.assertEquals(10, testStorage.getFruitList().get(0).getCount());
        Assert.assertEquals(date, testStorage.getFruitList().get(0).getExpirationDate());

        incomeShopOperation.transaction(testRecordIncome2);
        Assert.assertEquals(110, testStorage.getFruitList().get(0).getCount());
    }

}
