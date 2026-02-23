package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.Test;

class FruitTransactionTest {
    @Test
    void getters_isOk() {
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, "banana", 10);
        
        assertEquals(FruitTransaction.Operation.SUPPLY, transaction.getOperation());
        assertEquals("banana", transaction.getFruit());
        assertEquals(10, transaction.getQuantity());
    }

    @Test
    void getByCode_validCode_ok() {
        assertEquals(FruitTransaction.Operation.BALANCE, 
                FruitTransaction.Operation.getByCode("b"));
        assertEquals(FruitTransaction.Operation.SUPPLY, 
                FruitTransaction.Operation.getByCode("s"));
        assertEquals(FruitTransaction.Operation.PURCHASE, 
                FruitTransaction.Operation.getByCode("p"));
        assertEquals(FruitTransaction.Operation.RETURN, 
                FruitTransaction.Operation.getByCode("r"));
    }

    @Test
    void getByCode_validCodeWithSpaces_ok() {
        assertEquals(FruitTransaction.Operation.SUPPLY, 
                FruitTransaction.Operation.getByCode(" s "));
    }

    @Test
    void getByCode_nullCode_notOk() {
        assertThrows(IllegalArgumentException.class, () -> 
                FruitTransaction.Operation.getByCode(null));
    }

    @Test
    void getByCode_invalidCode_notOk() {
        assertThrows(IllegalArgumentException.class, () -> 
                FruitTransaction.Operation.getByCode("unknown"));
    }

    @Test
    void operationGetCode_isOk() {
        assertEquals("b", FruitTransaction.Operation.BALANCE.getCode());
    }
}
