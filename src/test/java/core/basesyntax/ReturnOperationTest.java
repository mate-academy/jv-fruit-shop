package core.basesyntax;

import core.basesyntax.operations.FruitOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class ReturnOperationTest {

    @Test
    public void returnOperationIsOk() {
        Map<String, Integer> actual = Storege.fruitStorage;
        FruitOperation returnOperation = new ReturnOperation();
        actual.put("banana", 50);
        returnOperation.fruitOperation(new ProductsDto("b", "banana", 13, LocalDate.parse("2020-10-17")));
        Assert.assertEquals(63, (int)actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void returnOperationWithExpiredDate() {
        FruitOperation supplyOperation = new SupplyOperation();
        supplyOperation.fruitOperation(new ProductsDto("b", "banana", 10, LocalDate.parse("2020-08-25")));
    }
}
