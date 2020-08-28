package core.basesyntax;

import core.basesyntax.operations.FruitOperation;
import core.basesyntax.operations.SupplyOperation;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Map;

public class SupplyOperationTest {

    @Test
    public void supplyOperationIsOk() {
        Map<String, Integer> actual = Storege.fruitStorage;
        FruitOperation supplyOperation = new SupplyOperation();
        actual.put("banana", 100);
        supplyOperation.fruitOperation(new ProductsDto("b", "banana", 100, LocalDate.parse("2020-10-17")));
        Assert.assertEquals(200, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void supplyOperationWithExpiredDate() {
        FruitOperation supplyOperation = new SupplyOperation();
        supplyOperation.fruitOperation(new ProductsDto("b", "banana", 10, LocalDate.parse("2020-08-24")));
    }
}
