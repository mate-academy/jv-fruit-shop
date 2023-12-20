package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseHandler;
import core.basesyntax.operations.ReturnHandler;
import core.basesyntax.operations.SupplyHandler;
import core.basesyntax.service.RaportCreator;
import core.basesyntax.service.file.FileReaderHandler;
import core.basesyntax.service.file.FileReaderHandlerImpl;
import core.basesyntax.service.processor.DataProcessor;
import core.basesyntax.service.processor.DataProcessorImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReaderHandler fileHandler = new FileReaderHandlerImpl();
        fileHandler.readFromFile();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);

        RaportCreator raportCreator = new RaportCreator();
        raportCreator.createRaport(dataProcessor.calculateData());

    }

}
