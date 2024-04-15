package core.basesyntax;

import java.util.List;
import model.FruitTransaction;
import service.FileReaderService;
import service.FruitTransactionMapper;
import service.FruitTransactionProcessor;
import service.ReportService;
import service.ReportWriterService;
import service.impl.FileReaderServiceImpl;
import service.impl.FruitTransactionMapperImpl;
import service.impl.FruitTransactionProcessorImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FruitTransactionMapper fruitTransactionMapper = new FruitTransactionMapperImpl();
        FruitTransactionProcessor fruitTransactionProcessor = new FruitTransactionProcessorImpl();
        ReportService reportService = new ReportServiceImpl();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        List<String> fruitTransactionsLines = fileReaderService.readFromFile();
        List<FruitTransaction> fruitTransactions = fruitTransactionMapper
                .map(fruitTransactionsLines);
        fruitTransactionProcessor.process(fruitTransactions);
        String report = reportService.createReport();
        reportWriterService.writeToFile(report);
    }
}
