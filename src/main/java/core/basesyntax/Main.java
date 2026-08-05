package core.basesyntax;

import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreator;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseTransaction;
import core.basesyntax.strategy.ReturnTransaction;
import core.basesyntax.strategy.SupplyTransaction;
import core.basesyntax.strategy.Transaction;
import core.basesyntax.strategy.TransactionHandler;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH = "src/main/resources/fruitOperations.csv";
    public static final String START_LINE = "type,fruit,quantity";
    public static final String OUTPUT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, Transaction> transactionMap = Map.of(
                "b", new BalanceTransaction(),
                "s", new SupplyTransaction(),
                "p", new PurchaseTransaction(),
                "r", new ReturnTransaction()
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(transactionMap);
        TransactionHandler transactionHandler = new TransactionHandler(operationStrategy);

        Reader reader = new ReaderImpl();
        ArrayList<String> lines = reader.readFromFile(INPUT_PATH);

        for (String line : lines) {
            if (line.equals(START_LINE)) {
                continue;
            }
            transactionHandler.process(line);
        }

        Writer writer = new WriterImpl();
        String report = ReportCreator.createReport();
        writer.writeToFile(OUTPUT_PATH, report);
    }
}
