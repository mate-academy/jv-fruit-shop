package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.entities.Product;
import core.basesyntax.model.impl.BalanceOperation;
import core.basesyntax.model.impl.PurchaseOperation;
import core.basesyntax.model.impl.ReturnOperation;
import core.basesyntax.model.impl.SupplyOperation;
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
        OperationSet existingOperation = OperationSet.P;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), PurchaseOperation.class);
    }

    @Test
    public void getBalanceOperation_ok() {
        OperationSet existingOperation = OperationSet.B;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), BalanceOperation.class);
    }

    @Test
    public void getReturnOperation_ok() {
        OperationSet existingOperation = OperationSet.R;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), ReturnOperation.class);
    }

    @Test
    public void getSupplyOperation_ok() {
        OperationSet existingOperation = OperationSet.S;
        AbstractOperation<Product> expectedOperation = operationFactory.get(existingOperation);
        assertEquals(expectedOperation.getClass(), SupplyOperation.class);
    }
}
