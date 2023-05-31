package core.basesyntax;

import core.basesyntax.services.imps.ReaderServiceImp;
import core.basesyntax.services.imps.ReportServiceImp;
import core.basesyntax.services.imps.TransactionServiceImp;
import core.basesyntax.services.imps.WriterServiceImp;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH = "src\\main\\resources\\source_file.csv";
    private static final String REPORT_FILE_PATH = "src\\main\\resources\\report_file.csv";

    public static void main(String[] args) {
        List<FruitTransaction> transactions = new TransactionServiceImp()
                .transactionProcessor(new ReaderServiceImp().readFromFile(SOURCE_FILE_PATH));
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        new OperationStrategy(operationHandlerMap);
        transactions
                .forEach(t -> operationHandlerMap
                        .get(t.getOperation()).toStorage(t));
        new WriterServiceImp()
                .writeToFile(REPORT_FILE_PATH, new ReportServiceImp().createReportString());
    }
}
