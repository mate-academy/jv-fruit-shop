package core.basesyntax;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FruitBalanceCheckService;
import service.FruitTransactionMapper;
import service.FruitTransactionProcessor;
import service.ReportService;
import service.ReportWriterService;
import service.impl.FileReaderServiceImpl;
import service.impl.FruitBalanceCheckServiceImpl;
import service.impl.FruitTransactionMapperImpl;
import service.impl.FruitTransactionProcessorImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FruitTransactionMapper fruitTransactionMapper = new FruitTransactionMapperImpl();
        FruitTransactionProcessor fruitTransactionProcessor = new FruitTransactionProcessorImpl();
        FruitBalanceCheckService fruitBalanceCheckService = new FruitBalanceCheckServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        List<String> fruitTransactionsLines = fileReaderService
                .readFromFile("src/main/resources/file.csv");
        List<FruitTransaction> fruitTransactions = fruitTransactionMapper
                .map(fruitTransactionsLines);
        Map<String, Integer> storageData = fruitTransactionProcessor.process(fruitTransactions);
        Storage.STORAGE.putAll(fruitBalanceCheckService.checkNegativeBalance(storageData));
        String report = reportService.createReport();
        reportWriterService.writeToFile("src/main/resources/report.csv", report);
    }
}
