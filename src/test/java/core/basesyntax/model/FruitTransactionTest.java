package core.basesyntax.model;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterFile;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterFileImpl;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerIn;
import core.basesyntax.strategy.OperationHandlerOut;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FruitTransactionTest {

    Map<FruitTransaction.Operation, OperationHandler>
            correspondenceTable = Map.of(
            FruitTransaction.Operation.BALANCE, new OperationHandlerBalance(),
            FruitTransaction.Operation.SUPPLY, new OperationHandlerIn(),
            FruitTransaction.Operation.RETURN, new OperationHandlerIn(),
            FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());

    @Test
    void getOperationByOperationCodeIs_Ok() {
        CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
        OperationHandler handlerBalance = calculateStrategy.getHandler(FruitTransaction.Operation.BALANCE);
        assertEquals(handlerBalance.getClass(), new OperationHandlerBalance().getClass());
        OperationHandler handlerReturn = calculateStrategy.getHandler(FruitTransaction.Operation.RETURN);
        assertEquals(handlerReturn.getClass(), new OperationHandlerIn().getClass());
        OperationHandler handlerPurchase = calculateStrategy.getHandler(FruitTransaction.Operation.PURCHASE);
        assertEquals(handlerPurchase.getClass(), new OperationHandlerOut().getClass());
    }

    @Test
    void operationGetByOperationIS_Ok() {
        FruitTransaction.Operation b = FruitTransaction.Operation.getByCode("b");
        assertTrue(b.equals(FruitTransaction.Operation.BALANCE));
        FruitTransaction.Operation r = FruitTransaction.Operation.getByCode("r");
        assertTrue(r.equals(FruitTransaction.Operation.RETURN));
        assertThrows(RuntimeException.class, () -> FruitTransaction.Operation.getByCode("x"));
    }
    @Test
    void enumTestIs_Ok() {
        assertEquals(4,FruitTransaction.Operation.values().length);

    }
    @Test
    void fieldsOfFruitTransactionIs_Ok(){
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit("banana");
        fruitTransaction.setQuantity(10);
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        assertEquals("banana", fruitTransaction.getFruit());
        assertEquals(10, fruitTransaction.getQuantity());
        assertEquals(FruitTransaction.Operation.BALANCE, fruitTransaction.getOperation());
    }
}