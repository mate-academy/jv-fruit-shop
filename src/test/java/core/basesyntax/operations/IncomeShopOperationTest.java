package core.basesyntax.operations;

import core.basesyntax.Record;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class IncomeShopOperationTest {
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final Storage testStorage = new Storage();
    public static final Record testRecordIncome = new Record("s", "pineapple",
            "10", "2020-08-26");
    public static final Record testRecordIncome2 = new Record("r", "pineapple",
            "100", "2020-08-26");
    @Test
    public void incomeShopOperationTestOk() {
        LocalDate date = LocalDate.parse("2020-08-26", YYYY_MM_DD);

        IncomeShopOperation incomeShopOperation = new IncomeShopOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        Assert.assertEquals("pineapple", testStorage.getFruitSupplies().get(0).getProductName());
        Assert.assertEquals(10, testStorage.getFruitSupplies().get(0).getCount());
        Assert.assertEquals(date, testStorage.getFruitSupplies().get(0).getExpirationDate());

        incomeShopOperation.transaction(testRecordIncome2);
        Assert.assertEquals(110, testStorage.getFruitSupplies().get(0).getCount());
    }

}