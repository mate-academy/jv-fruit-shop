package core.basesyntax;

import core.basesyntax.service.operations.PurchaseOperation;
import org.junit.BeforeClass;
import org.junit.Test;

public class PurchaseOperationTest {
    private static PurchaseOperation purchaseOperation;

    @BeforeClass
    public static void setUp() {
        purchaseOperation = new PurchaseOperation();
    }

    @Test(expected = RuntimeException.class)
    public void purchaseOperationTest_NotOk() {
        purchaseOperation.operation(10, 15);
    }
}
