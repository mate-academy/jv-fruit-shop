package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionEvaluator;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.TransactionEvaluatorImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class MainApp {
    private static final String INPUT_CSV = "input.csv";
    private static final String OUTPUT_CSV = "results.csv";
    private static ReaderService readerService = new ReaderServiceImpl();
    private static TransactionParserService parser = new TransactionParserServiceImpl();
    private static TransactionEvaluator evaluationFruits = new TransactionEvaluatorImpl();
    private static ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
    private static WriterService writerService = new WriterServiceImpl();

    public static void main(String[] args) {
        List<String> recordsOfData = readerService.readFileToList(INPUT_CSV);
        List<FruitTransaction> parsedData = parser.parse(recordsOfData);
        evaluationFruits.evaluate(parsedData);
        String dataOfReport = reportGeneratorService.generateReportText(Storage.storage);
        writerService.writeReportToFile(OUTPUT_CSV, dataOfReport);
    }
}
