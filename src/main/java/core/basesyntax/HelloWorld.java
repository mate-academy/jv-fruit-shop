package core.basesyntax;

import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.implementations.DataProcessorImpl;
import core.basesyntax.service.implementations.FruitTransaction;
import core.basesyntax.service.implementations.OperationStrategyImpl;
import core.basesyntax.service.implementations.ReaderServiceImpl;
import core.basesyntax.service.implementations.WriterServiceImpl;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE,
                                    new BalanceOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                                    new PurchaseOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN,
                                    new ReturnOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                                    new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> read = readerService.readFromFile();
        read.remove(0);
        DataProcessor dataProcessor = new DataProcessorImpl();
        dataProcessor.processData(read, operationStrategy);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(dataProcessor.provideReport());
    }
}
