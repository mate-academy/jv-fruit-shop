package core.basesyntax;

import core.basesyntax.dao.CsvDao;
import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.dto.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new CsvDao();

        FruitStorage fruitStorage = new FruitStorage(new TreeMap<>());

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnHandler(fruitStorage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandler(fruitStorage));

        Path readPath = Path.of("src/main/resources/input.csv");
        Path writePath = Path.of("src/main/resources/report.csv");

        FruitTransactionParser fruitTransactionParser = new CsvParser();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<String> data = fruitShopDao.loadDataFromFile(readPath);
        List<FruitTransaction> transactions = fruitTransactionParser.parseTransactions(data);
        OperationHandler operationHandler;
        for (var transaction : transactions) {
            operationHandler = operationStrategy.findHandler(transaction.operation());
            operationHandler.handle(transaction.fruit(), transaction.quantity());
        }

        ReportCreator reportCreator = new ReportCreatorImpl();
        fruitShopDao.saveDataToFile(writePath, reportCreator.create(fruitStorage));
    }
}
