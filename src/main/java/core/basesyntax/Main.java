package core.basesyntax;

import core.basesyntax.db.FruitDB;
import core.basesyntax.db.HashMapFruitDB;
import core.basesyntax.model.ReportRecord;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.service.TransactionReaderService;
import core.basesyntax.service.impl.CsvFileReportWriterService;
import core.basesyntax.service.impl.CsvFileTransactionReaderService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.TransactionProcessorServiceStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILENAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILENAME = "src/main/resources/output.csv";
    private final TransactionReaderService transactionReaderService;
    private final TransactionParserService transactionParserService;
    private final TransactionProcessorServiceStrategy transactionProcessorServiceStrategy;
    private final ReportService reportService;
    private final ReportWriterService reportWriterService;

    public Main() {
        FruitDB db = new HashMapFruitDB();
        transactionReaderService = new CsvFileTransactionReaderService(INPUT_FILENAME);
        transactionParserService = new TransactionParserServiceImpl();
        transactionProcessorServiceStrategy = new TransactionProcessorServiceStrategy(db);
        reportService = new ReportServiceImpl(db);
        reportWriterService = new CsvFileReportWriterService(OUTPUT_FILENAME);
    }

    void run() {
        List<String> strings = transactionReaderService.read();
        List<Transaction> transactions = transactionParserService.parse(strings);

        for (Transaction transaction : transactions) {
            TransactionProcessorService transactionProcessorService
                    = transactionProcessorServiceStrategy.get(transaction.getOperation());
            transactionProcessorService.process(transaction);
        }

        List<ReportRecord> reportRecords = reportService.generate();
        reportWriterService.write(reportRecords);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
