package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH_NAME = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH_NAME = "src/main/resources/DailyReport.csv";
    private static FileReaderService fileReaderService;
    private static FruitTransactionParser fruitTransactionParser;
    private static TransactionProcessor transactionProcessor;
    private static ReportGenerator reportGenerator;
    private static FileWriterService fileWriterService;

    public static void main(String[] args) {
        fileReaderService = new FileReaderServiceImpl();
        fruitTransactionParser = new FruitTransactionParserImpl();
        transactionProcessor = new TransactionProcessorImpl();
        reportGenerator = new ReportGeneratorImpl();
        fileWriterService = new FileWriterServiceImpl();

        OperationStrategy.strategyMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        OperationStrategy.strategyMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy.strategyMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        OperationStrategy.strategyMap
                .put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        List<String> dataFromFile = fileReaderService.readFromFile(INPUT_FILE_PATH_NAME);
        List<FruitTransaction> transactions = fruitTransactionParser
                .transformToTransaction(dataFromFile);
        transactionProcessor.process(transactions);
        String report = reportGenerator.generate();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH_NAME, report);
    }
}
