package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.SupplyOperation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class SupplyOperationTest {

    @Test
    public void supplyOperationOk() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Operation supplyOperation = new SupplyOperation();
        actual.put("banana", 100);
        supplyOperation.apply(new FruitDto("b", "banana", 10, LocalDate.parse("2020-10-17")));
        Assert.assertEquals(110, (int)actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void supplyOperationWithExpiredDate() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Operation supplyOperation = new SupplyOperation();
        actual.put("banana", 100);
        supplyOperation.apply(new FruitDto("b", "banana", 10, LocalDate.parse("2020-08-17")));
    }
}
