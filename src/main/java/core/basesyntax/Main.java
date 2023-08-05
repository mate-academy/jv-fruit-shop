package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.TotalService;
import core.basesyntax.service.TotalServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationActivities;
import core.basesyntax.strategy.OperationActivities;
import core.basesyntax.strategy.PurchaseOperationActivities;
import core.basesyntax.strategy.ReturnOperationActivities;
import core.basesyntax.strategy.SupplyOperationActivities;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String FILE_FROM = "fruits.csv";
    private static final String FILE_TO = "fruitsResult.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        readerService.readFromFile(FILE_PATH + FILE_FROM);

        Map<FruitTransaction.Operation, OperationActivities>
                operationStrategiesMap = new HashMap<>();
        operationStrategiesMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationActivities());
        operationStrategiesMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationActivities());
        operationStrategiesMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationActivities());
        operationStrategiesMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationActivities());

        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationStrategiesMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.calcFruitTransaction();

        TotalService totalService = new TotalServiceImpl();
        String strReport = totalService.getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(strReport,FILE_PATH + FILE_TO);
    }
}
