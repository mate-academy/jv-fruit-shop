package core.basesyntax.application;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileDataParser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FileDataParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();
    private static final FileDataParser fileDataParser = new FileDataParserImpl();
    private static final TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String reportFilePath = "src/main/resources/report.csv";

        List<String> data = readerService.readFromFile(inputFilePath);
        List<Transaction> transactions = fileDataParser.parse(data);
        transactionProcessor.executeTransactions(transactions);
        List<String> report = reportService.generateReport();
        writerService.writeToFile(report, reportFilePath);
    }
}
