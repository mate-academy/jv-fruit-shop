package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.FruitDb;
import core.basesyntax.db.HashMapFruitDb;
import core.basesyntax.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutgoingTransactionProcessorServiceTest {
    private static final String APPLE = "apple";
    private static final Transaction.Operation OPERATION = Transaction.Operation.PURCHASE;
    private FruitDb db;
    private OutgoingTransactionProcessorService processorService;

    @BeforeEach
    void setUp() {
        db = new HashMapFruitDb();
        processorService = new OutgoingTransactionProcessorService(db);
    }

    @Test
    void process_noFruitInDatabase_success() {
        processorService.process(new Transaction(OPERATION, APPLE, 10));
        assertEquals(-10, db.getQuantity(APPLE));
    }

    @Test
    void process_fruitIsInDatabase_success() {
        db.setQuantity(APPLE, 10);
        processorService.process(new Transaction(OPERATION, APPLE, 7));
        assertEquals(3, db.getQuantity(APPLE));
    }
}
