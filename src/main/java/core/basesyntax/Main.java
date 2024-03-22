package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReporterService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReporterServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import java.util.List;

public class Main {
    private static final String PATH_FROM
            = "src/main/resources/input.csv";
    private static final String PATH_TO
            = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        FileReaderService readService
                = new FileReaderServiceImpl();
        FruitTransactionParser listFruitTransactions =
                new FruitTransactionParserImpl();
        StorageService storageService
                = new StorageServiceImpl(storage);
        TransactionProcessorImpl transactionProcessor
                = new TransactionProcessorImpl(storageService);
        ReporterService reportService
                = new ReporterServiceImpl(storageService);
        FileWriterService writerService
                = new FileWriterServiceImpl();
        List<String> inputData = readService.readFile(PATH_FROM);

        List<FruitsTransaction> fruitsTransactionList
                = listFruitTransactions.parse(inputData);

        transactionProcessor.executeTransactions(fruitsTransactionList);

        String readyReport = reportService.createReport();

        writerService.writeToFile(PATH_TO, readyReport);
    }
}
