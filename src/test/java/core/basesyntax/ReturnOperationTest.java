package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.ReturnOperation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class ReturnOperationTest {

    @Test
    public void buyActionOk() {
        Map<String, Integer> actual = FruitStore.fruitStorage;
        Operation buyAction = new ReturnOperation();
        actual.put("banana", 100);
        buyAction.apply(new FruitDto("b", "banana", 10, LocalDate.parse("2020-10-17")));

        Assert.assertEquals(110, (int)actual.get("banana"));
    }
}
