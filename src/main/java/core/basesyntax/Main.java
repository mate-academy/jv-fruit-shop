package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TotalService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TotalServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationActivity;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationActivity;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationActivity;
import core.basesyntax.strategy.impl.ReturnOperationActivity;
import core.basesyntax.strategy.impl.SuppliyOperationActivity;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/fruits.csv";
    private static final String FILE_TO = "src/main/resources/fruitsResult.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        readerService.readFromFile(FILE_FROM);
        Map<FruitTransaction.Operation, OperationActivity>
                operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationActivity());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY,
                new SuppliyOperationActivity());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationActivity());
        operationStrategies.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationActivity());
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationStrategies);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.calculate();
        TotalService totalService = new TotalServiceImpl();
        String report = totalService.getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, FILE_TO);
    }
}
