package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.reader.Reader;
import core.basesyntax.reader.ReaderImpl;
import core.basesyntax.reportservice.ReportService;
import core.basesyntax.reportservice.ReportServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationServiceStrategy;
import core.basesyntax.writer.Writer;
import core.basesyntax.writer.WriterImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final String OUTPUT_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        String data = reader.read(INPUT_FILE_NAME);
        Storage storage = new Storage();
        List<Transaction> transactionList = new ParserImpl().parse(data);
        OperationServiceStrategy operationServiceStrategy = new OperationServiceStrategy();
        for (Transaction transaction : transactionList) {
            operationServiceStrategy
                    .getOperationServiceByOperationType(transaction.getOperation())
                    .interact(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        Writer writer = new WriterImpl();
        writer.write(reportService.createReport(Storage.getAll()), OUTPUT_FILE_NAME);
    }
}
