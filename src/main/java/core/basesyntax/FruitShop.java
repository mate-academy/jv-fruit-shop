package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.serviceimpl.ParserServiceImpl;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILE_NAME = "src/main/java/files/data.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/java/files/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> handlerMap = new HashMap<>();
        initialize(handlerMap);
        Strategy operationStrategy = new StrategyImpl(handlerMap);

        List<String> dataFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new ParserServiceImpl().parse(dataFromFile);

        for (Transaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().getReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }

    private static void initialize(Map<Operation, OperationHandler> map) {
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
    }
}
