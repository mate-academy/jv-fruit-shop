package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.DataParseService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String PATH_FROM
            = "src/main/resources/input.csv";
    private static final String PATH_TO
            = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        ReadFromFileService readService
                = new ReadFromFileServiceImpl();
        DataParseService listFruitTransactions =
                new DataParseServiceImpl();
        StorageService storageService
                = new StorageServiceImpl(storage);
        TransactionProcessorImpl transactionProcessor
                = new TransactionProcessorImpl(storageService);
        ReportService reportService
                = new ReportServiceImpl(storageService);
        WriterService writerService
                = new WriterServiceImpl();
        List<String> inputData = readService.readFile(PATH_FROM);

        List<FruitsTransaction> fruitsTransactionList
                = listFruitTransactions.getTransactionList(inputData);

        transactionProcessor.executeTransactions(fruitsTransactionList);

        String readyReport = reportService.createReport();

        writerService.writeToFile(PATH_TO, readyReport);
    }
}
