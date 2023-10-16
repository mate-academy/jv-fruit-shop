package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FruitTransactionTest {

    @Test
    void getOperation_validOperation_ok() {
        FruitTransaction.Operation actualOperation = FruitTransaction.Operation
                .getOperationByCode("b");
        FruitTransaction.Operation exceptedOPeration = FruitTransaction.Operation.BALANCE;
        Assertions.assertEquals(exceptedOPeration, actualOperation);
    }

    @Test
    void get_operation_notValidOperation_notOk() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> FruitTransaction.Operation.getOperationByCode("x"));
    }
}
