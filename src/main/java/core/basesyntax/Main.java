package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/database.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlersMap = new HashMap<>();
        handlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlersMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        handlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlersMap);

        List<String> dataSheet = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> transactions = new TransactionParserServiceImpl().parse(dataSheet);

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().generateReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
