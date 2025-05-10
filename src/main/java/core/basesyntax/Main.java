package core.basesyntax;

import core.basesyntax.context.OperationContext;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvParserService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderService();
        List<String> lines = readerService.readFromFile(INPUT_FILE_PATH);
        ParserService parserService = new CsvParserService();
        List<FruitTransaction> transactions = parserService.parseCsv(lines);

        FruitStorage fruitStorage = new FruitStorage();
        ReportService reportService = new ReportService(fruitStorage);

        System.out.print("Report before processing transactions: "
                + reportService.generateReport());

        OperationContext operationContext = new OperationContext(fruitStorage);
        for (FruitTransaction transaction : transactions) {
            if (transaction != null) {
                operationContext.getOperation(transaction.getOperation())
                        .performOperation(transaction);
            }
        }

        String report = reportService.generateReport();
        System.out.println("Report after processing transactions: " + report);

        WriterService writerService = new CsvWriterService();
        writerService.writeToCsv(report, OUTPUT_FILE_PATH);
    }
}
