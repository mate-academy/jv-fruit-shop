package core.basesyntax.operations;

import core.basesyntax.Record;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExpendShopOperationTest {
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
        IncomeShopOperation incomeShopOperation = new IncomeShopOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        ExpendShopOperation expendShopOperation = new ExpendShopOperation(testStorage);
        expendShopOperation.transaction(testRecordExpend);

        Assert.assertEquals(95, testStorage.getFruitSupplies().get(0).getCount());
    }

    @Test(expected = RuntimeException.class)
    public void expendShopOperationTestFail() {
        IncomeShopOperation incomeShopOperation = new IncomeShopOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);

        ExpendShopOperation expendShopOperation = new ExpendShopOperation(testStorage);
        expendShopOperation.transaction(testRecordExpend2);
    }

    @Test
    public void getAvailableCountTest() {
        IncomeShopOperation incomeShopOperation = new IncomeShopOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome);
        incomeShopOperation.transaction(testRecordIncome2);

        Assert.assertEquals(300, testStorage.getFruitSupplies().get(0).getCount());
        testStorage.getFruitSupplies().clear();
    }
}