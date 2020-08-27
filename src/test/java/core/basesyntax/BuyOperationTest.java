package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class BuyOperationTest {

    @Test
    public void buyActionOk() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Map<String, LocalDate> expirationDate = FruitStore.expirationDateStorage;
        Operation buyAction = new BuyOperation();
        actual.put("banana", 100);
        expirationDate.put("banana", LocalDate.parse("2020-10-17"));
        buyAction.apply(new FruitDto("b", "banana", 10, LocalDate.parse("2020-10-17")));

        Assert.assertEquals(90, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void buyQuantityMoreThanExist() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Operation buyAction = new BuyOperation();
        actual.put("banana", 100);
        buyAction.apply(new FruitDto("b", "banana", 103, LocalDate.parse("2020-10-17")));
    }
}
