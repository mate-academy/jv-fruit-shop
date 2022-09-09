package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.FileParserImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.AddOperationHandler;
import core.basesyntax.strategy.impl.SubtractOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static OperationStrategy getOperationStrategyMap() {
        Map<Transaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(Transaction.Operation.BALANCE, new AddOperationHandler());
        map.put(Transaction.Operation.PURCHASE, new SubtractOperationHandler());
        map.put(Transaction.Operation.RETURN, new AddOperationHandler());
        map.put(Transaction.Operation.SUPPLY, new AddOperationHandler());
        return new OperationStrategy(map);
    }

    public static void main(String[] args) {
        OperationStrategy operationStrategy = getOperationStrategyMap();
        FileReader reader = new FileReaderImpl();
        List<String> lines = reader.readFileLines(INPUT_FILE);
        List<Transaction> transactions = new FileParserImpl().parseTransactionList(lines);

        for (Transaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandlerByOperation(transaction.getOperation());
            operationHandler.perform(transaction);
        }
        String report = new ReportCreatorImpl().getReport();
        new FileWriterImpl().writeReportToFile(OUTPUT_FILE, report);
    }
}
