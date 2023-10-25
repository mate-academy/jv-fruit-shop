package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FileParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = new FileReaderServiceImpl().read(INPUT_FILE);
        final List<FruitTransaction> fruitTransactions = new FileParserServiceImpl()
                .parse(dataFromFile);
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = strategy.getHandler(fruitTransaction.getOperation());
            handler.getTransaction(fruitTransaction);
            new FileWriterServiceImpl().write(REPORT_FILE,
                    new ReportGeneratorServiceImpl().generate());
        }
    }
}
