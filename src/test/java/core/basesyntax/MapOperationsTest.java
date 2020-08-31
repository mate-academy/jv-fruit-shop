package core.basesyntax;

import core.basesyntax.service.MapOperations;
import core.basesyntax.service.impl.SupplyOrReturnOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapOperationsTest {

    private FruitStorage fruitStorage;
    private MapOperations mapOperations;

    @Before
    public void setUpVariables() {
        mapOperations = new MapOperations();
        fruitStorage = new FruitStorage();
    }

    @Test
    public void addOperationTestOk() {
        mapOperations.addOperation("s", new SupplyOrReturnOperation(fruitStorage));
        int actual = mapOperations.size();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void getOperationTestOk() {
        mapOperations.addOperation("s", new SupplyOrReturnOperation(fruitStorage));
        boolean actual = mapOperations.getOperation("s").getClass() == SupplyOrReturnOperation.class;
        Assert.assertTrue(actual);
    }
}
