package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.impl.ParserServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/main/resources/input.csv";

    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();

        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        ParserServiceImpl transactionParser = new ParserServiceImpl();
        List<String> lines = fileReader.readData(FILE_NAME);
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        OperationStrategy operationStrategy = new OperationStrategy();
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            operationHandler.handleOperation(transaction, storage);
        }
        ReportService reportCreator = new ReportService();
        WriterServiceImpl fileWriter = new WriterServiceImpl();
        fileWriter.writeToFile(reportCreator.generateReport(), REPORT_FILE_NAME);
    }
}
