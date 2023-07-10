package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadingFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ReadingFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WritingFileServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Application {
    private static final String INPUT_FILE = "src/main/resources/fruits_data.csv";
    private static final String OUTPUT_FILE = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        // reading file
        ReadingFileService readingFileService = new ReadingFileServiceImpl();
        List<String> fileLines = readingFileService.readDataFromFile(INPUT_FILE);
        // translate strings into a fieldset
        TransactionParserImpl transactionParser = new TransactionParserImpl();
        final List<FruitTransaction> fruitTransactions = transactionParser.parseData(fileLines);
        // creating strategy map
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        // filling the strategy with data
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.applyTransactionToStorage(fruitTransaction);
        }
        // preparing final report
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();
        // writing report to file
        WritingFileServiceImpl writingFileService = new WritingFileServiceImpl();
        writingFileService.writingDataToFile(report, OUTPUT_FILE);
    }
}
