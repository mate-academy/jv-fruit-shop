package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionParserImpl;
import core.basesyntax.service.strategy.ActivitiesStrategy;
import core.basesyntax.service.strategy.ActivitiesStrategyImpl;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFromFile = fileReaderService
                .readFromFile("src/main/resources/remnants-of-fruit.csv");
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<FruitTransaction> parser = fruitTransactionParser.parse(readFromFile);
        ActivitiesStrategy strategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        for (int i = 0; i < parser.size(); i++) {
            FruitTransaction.Operation operation = parser.get(i).getOperation();
            OperationHandler handler = strategy.get(operation);
            handler.handle(parser.get(i));
        }

        StorageDao storageDao = new StorageDaoImpl();
        StringBuilder report = new StringBuilder();
        for (Map.Entry entry:storageDao.getFromStorage().entrySet()) {
            Fruit fruit = (Fruit) entry.getKey();
            report.append(fruit.getName()).append(", ")
                    .append(entry.getValue()).append(System.lineSeparator());
        }

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeData("src/main/resources/report.csv", report.toString());
    }
}
