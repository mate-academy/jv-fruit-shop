package core.basesyntax;

import core.basesyntax.files.FileReaderService;
import core.basesyntax.files.FileReaderServiceImpl;
import core.basesyntax.files.FileWriterService;
import core.basesyntax.files.FileWriterServiceImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.OperationProcessImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/transactions.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/dailyReport";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        TransactionParser dataParser = new TransactionParserImpl();
        List<String> dataFromFile = fileReaderService
                .readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactionList = dataParser.parseTransactions(dataFromFile);
        System.out.println(fruitTransactionList);
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        OperationProcess operationProcess = new OperationProcessImpl(operationStrategy);
        operationProcess.processTransactions(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, OUTPUT_FILE_PATH);
    }
}
