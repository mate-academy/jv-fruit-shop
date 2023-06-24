package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionEvaluatorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.TransactionEvaluatorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.CalculationStrategy;
import core.basesyntax.strategy.impl.CalculationStrategyImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        CalculationStrategy calculationStrategy = new CalculationStrategyImpl();
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        TransactionParserService transactionParserService = new TransactionParserServiceImpl();
        TransactionEvaluatorService transactionEvaluator =
                new TransactionEvaluatorServiceImpl(calculationStrategy);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();

        List<String> fruitsList = fileReaderService.readToList(INPUT_FILE_NAME);
        List<FruitTransaction> transactions = transactionParserService
                .parseToFruitTransaction(fruitsList);
        transactionEvaluator.process(transactions);
        String report = reportGenerator.generateReport(Storage.storage);
        fileWriterService.writeReportToFile(report, OUTPUT_FILE_PATH);
    }
}
