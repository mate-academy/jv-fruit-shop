package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ProcessDataService;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.WriterService;
import core.basesyntax.servise.impl.ProcessDataServiceImpl;
import core.basesyntax.servise.impl.ReaderServiceImpl;
import core.basesyntax.servise.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperation;
import core.basesyntax.strategy.operation.ReturnOperation;
import core.basesyntax.strategy.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INITIAL_FILE_PATH = "src/main/resources/data.csv";
    private static final String RESULT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        ReaderService reader = new ReaderServiceImpl();
        List<FruitTransaction> fruitTransactions = reader.readFromCsv(INITIAL_FILE_PATH);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        ProcessDataService data = new ProcessDataServiceImpl(operationStrategy);
        String report = data.processData(fruitTransactions);
        WriterService writer = new WriterServiceImpl();
        writer.writeReportToCsv(RESULT_FILE_PATH, report);
    }
}
