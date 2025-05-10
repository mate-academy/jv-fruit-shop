package core.basesyntax;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionMapper;
import service.FruitTransactionProcessor;
import service.ReportService;
import service.ReportWriterService;
import service.impl.FileReaderService;
import service.impl.FruitTransactionMapperImpl;
import service.impl.FruitTransactionProcessorImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {

    public static void main(String[] args) {
        final FileReaderService fileReaderService = new FileReaderService();
        final FruitTransactionMapper fruitTransactionMapper = new FruitTransactionMapperImpl();
        final FruitTransactionProcessor
                fruitTransactionProcessor = new FruitTransactionProcessorImpl();
        final ReportService reportService = new ReportServiceImpl();
        final ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        final List<String> fruitTransactionsLines = fileReaderService
                .readFromFile("src/main/resources/file.csv");
        List<FruitTransaction> fruitTransactions = fruitTransactionMapper
                .map(fruitTransactionsLines);
        fruitTransactionProcessor.process(fruitTransactions);
        String report = reportService.createReport();
        reportWriterService.writeToFile("src/main/resources/report.csv", report);
    }
}
