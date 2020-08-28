package core.basesyntax.operations;

import core.basesyntax.Record;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

public class ExpendShopOperationTest {
    public static final Record testRecordIncome2 = new Record("r", "pineapple", "100", "2020-08-26");
    public static final Record testRecordExpend = new Record("b", "pineapple", "5", "2020-08-25");
    public static final Storage testStorage = new Storage();
    @Test
    public void ExpendShopOperationTestOk() {
        IncomeShopOperation incomeShopOperation = new IncomeShopOperation(testStorage);
        incomeShopOperation.transaction(testRecordIncome2);

        ExpendShopOperation expendShopOperation = new ExpendShopOperation(testStorage);
        expendShopOperation.transaction(testRecordExpend);

        Assert.assertEquals(95, testStorage.getFruitSupplies().get(0).getCount());
    }

}