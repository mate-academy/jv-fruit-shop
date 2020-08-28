package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.FruitOperation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class BuyOperationTest {
    @Test
    public void buyOperationIsOk(){
        Map<String, Integer> actual = Storege.fruitStorage;
        FruitOperation buyOperation = new BuyOperation();
        actual.put("banana", 100);
        buyOperation.fruitOperation(new ProductsDto("b", "banana", 15, LocalDate.parse("2020-10-17")));
        Assert.assertEquals(85, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void buyQuantityMoreThanExist() {
        Map<String, Integer> actual = Storege.fruitStorage;
        FruitOperation buyOperation = new BuyOperation();
        actual.put("banana", 45);
        buyOperation.fruitOperation(new ProductsDto("b", "banana", 95, LocalDate.parse("2020-10-17")));
    }
}
