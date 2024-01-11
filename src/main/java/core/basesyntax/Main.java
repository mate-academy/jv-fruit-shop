package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseHandler;
import core.basesyntax.operations.ReturnHandler;
import core.basesyntax.operations.SupplyHandler;
import core.basesyntax.service.RapportCreator;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.file.FileReader;
import core.basesyntax.service.file.FileReaderImpl;
import core.basesyntax.service.processor.DataProcessor;
import core.basesyntax.service.processor.DataProcessorImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReaderImpl();

        StorageDao storageDao = new StorageDaoImpl();

        StorageService service = new StorageServiceImpl(storageDao);
        service.createNewFruitTransaction(fileReader.readFromFile("fruitsRapport.csv"));

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);

        RapportCreator rapportCreator = new RapportCreator();
        rapportCreator.createRapport("rapport.csv", dataProcessor.calculateData());

    }

}
