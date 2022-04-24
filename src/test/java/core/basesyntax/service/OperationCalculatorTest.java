package core.basesyntax.service;

import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class OperationCalculatorTest {
    public final static Record testRecordIncome =
            new Record("s", "pineapple", "10", "2020-08-26");
    public final static Record testRecordIncome2 =
            new Record("r", "pineapple", "100", "2020-08-26");
    public final static Record testRecordIncome3 =
            new Record("r", "banana", "30", "2020-10-26");
    public final static Record testRecordExpend =
            new Record("b", "pineapple", "5", "2020-08-25");
    public final static Storage testStorage = new Storage();

    @Test
    public void productCalculatorServiceTestOk() {
        List<Record> recordList = new ArrayList<>();
        recordList.add(testRecordIncome);
        recordList.add(testRecordIncome2);
        recordList.add(testRecordIncome3);
        recordList.add(testRecordExpend);

        OperationCalculator productCalculatorService = new OperationCalculator(testStorage);
        productCalculatorService.calculateBalance(recordList);

        Assert.assertEquals(2, testStorage.getFruitList().size());
        Assert.assertEquals(105, testStorage.getFruitList().get(0).getCount());
    }

}
