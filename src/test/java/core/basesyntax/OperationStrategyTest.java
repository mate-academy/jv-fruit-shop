package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperationStrategyTest {
    private OperationStrategy operationStrategy = new OperationStrategy();
    private Storage storage = new Storage();

    @Test
    public void toFulfillAllOrdersOk() {
        List<FruitPackage> fruitPackagesList = new ArrayList<>();
        LocalDate localDateLime = LocalDate.parse("2019-10-14");
        FruitPackage fruitPackageLime = new FruitPackage("lime", 5, localDateLime);
        fruitPackagesList.add(fruitPackageLime);
        List<List<String>> data = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("s");
        row1.add("grape");
        row1.add("10");
        row1.add("2019-10-13");
        List<String> row2 = new ArrayList<>();
        row2.add("s");
        row2.add("lime");
        row2.add("10");
        row2.add("2019-10-14");
        List<String> row3 = new ArrayList<>();
        row3.add("b");
        row3.add("grape");
        row3.add("10");
        row3.add("2019-10-13");
        List<String> row4 = new ArrayList<>();
        row4.add("b");
        row4.add("lime");
        row4.add("5");
        row4.add("2019-10-12");
        data.add(row1);
        data.add(row2);
        data.add(row3);
        data.add(row4);
        operationStrategy.fulfillAllOrders(data, storage);
        Assert.assertEquals(fruitPackagesList.size(), storage.getFruitPackages().size());
        Assert.assertEquals(fruitPackagesList.get(0).getAmount(), storage.getFruitPackages().get(0).getAmount());
        Assert.assertEquals(fruitPackagesList.get(0).getType(), storage.getFruitPackages().get(0).getType());
        Assert.assertEquals(fruitPackagesList.get(0).getDate(), storage.getFruitPackages().get(0).getDate());
    }
}
