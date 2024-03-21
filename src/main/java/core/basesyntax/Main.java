package core.basesyntax;

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
        ReadFromFileService readService = new ReadFromFileServiceImpl();
        DataParseService listFruitTransactions = new DataParseServiceImpl();
        StorageService storageService = new StorageServiceImpl();
        TransactionProcessorImpl transactionProcessor = new TransactionProcessorImpl();
        ReportService reportService = new ReportServiceImpl(storageService);
        WriterService writerService = new WriterServiceImpl();

        List<String> inputData = readService.readFile(PATH_FROM);

        transactionProcessor.executeTransactions(
                listFruitTransactions.getTransactionList(inputData));

        List<String> readyReport = reportService.createReport();

        writerService.writeToFile(PATH_TO, readyReport);
    }
}
