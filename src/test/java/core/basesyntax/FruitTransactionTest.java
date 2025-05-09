package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FruitTransactionTest {
    @Test
    void nonExistCode_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            FruitTransaction.Operation.fromCode("Invalid code");
        });
    }

}
