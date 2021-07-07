package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.service.Record;
import org.junit.Assert;
import org.junit.Test;


public class SellOperationTest {
    public static final Record testRecordIncome = new Record("r", "pineapple",
            "100", "2020-08-26");
    public static final Record testRecordIncome2 = new Record("r", "pineapple",
            "200", "2020-08-26");
    public static final Record testRecordExpend = new Record("b", "pineapple",
            "5", "2020-08-25");
    public static final Record testRecordExpend2 = new Record("b", "pineapple",
            "500", "2020-08-25");
    public static final Storage testStorage = new Storage();

    @Test
    public void expendShopOperationTestOk() {
        SupplyAndReturnOperation incomeShopOperation = new SupplyAndReturnOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        SellOperation expendShopOperation = new SellOperation(testStorage);
        expendShopOperation.transaction(testRecordExpend);

        Assert.assertEquals(95, testStorage.getFruitList().get(0).getCount());
    }

    @Test(expected = RuntimeException.class)
    public void expendShopOperationTestFail() {
        SupplyAndReturnOperation incomeShopOperation = new SupplyAndReturnOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        SellOperation expendShopOperation = new SellOperation(testStorage);
        expendShopOperation.transaction(testRecordExpend2);
    }

    @Test
    public void getAvailableCountTest() {
        SupplyAndReturnOperation incomeShopOperation = new SupplyAndReturnOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);
        incomeShopOperation.transaction(testRecordIncome2);

        Assert.assertEquals(300, testStorage.getFruitList().get(0).getCount());
        testStorage.getFruitList().clear();
    }
}
