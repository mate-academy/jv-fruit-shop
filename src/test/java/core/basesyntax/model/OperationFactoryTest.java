package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.entities.Product;
import core.basesyntax.model.strategy.AbstractOperation;
import core.basesyntax.model.strategy.BalanceOperation;
import core.basesyntax.model.strategy.OperationFactory;
import core.basesyntax.model.strategy.PurchaseOperation;
import core.basesyntax.model.strategy.ReturnOperation;
import core.basesyntax.model.strategy.SupplyOperation;
import org.junit.Before;
import org.junit.Test;

public class OperationFactoryTest {
    private OperationFactory<Product> operationFactory;

    @Before
    public void setUp() {
        operationFactory = new OperationFactory<>(null);
    }

    @Test
    public void getPurchaseOperation_ok() {
        Operation existingOperation = Operation.P;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), PurchaseOperation.class);
    }

    @Test
    public void getBalanceOperation_ok() {
        Operation existingOperation = Operation.B;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), BalanceOperation.class);
    }

    @Test
    public void getReturnOperation_ok() {
        Operation existingOperation = Operation.R;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), ReturnOperation.class);
    }

    @Test
    public void getSupplyOperation_ok() {
        Operation existingOperation = Operation.S;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), SupplyOperation.class);
    }
}
