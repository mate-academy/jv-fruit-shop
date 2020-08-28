package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.SupplyAndReturnOperation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class SupplyAndReturnOperationTest {

    @Test
    public void supplyOperationOk() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Operation supplyOperation = new SupplyAndReturnOperation();
        actual.put("banana", 100);
        supplyOperation.apply(new TransactionDto("b", "banana", 10, LocalDate.parse("2020-10-17")));
        Assert.assertEquals(110, (int)actual.get("banana"));
    }
}
