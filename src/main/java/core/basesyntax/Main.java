package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FOLDER = "src/main/resources";
    private static final String INPUT_FILE = "input.csv";
    private static final String OUTPUT_FILE = "output.csv";

    public static void main(String[] args) {
        File inputFile = new File(FOLDER, INPUT_FILE);

        FileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> strings = csvFileReaderService.read(inputFile);

        /**
         *     b - balance, the remnants of fruits at the beginning of the working day
         *     s - supply, means you are receiving new fruits from suppliers
         *     p - purchase, means someone has bought some fruit
         *     r - return, means someone who have bought the fruits now returns them back
         */
        Map<String, Strategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceStrategy());
        operationStrategies.put("s", new SupplyStrategy());
        operationStrategies.put("p", new PurchaseStrategy());
        operationStrategies.put("r", new ReturnStrategy());

        ParserService parserService = new ParserServiceImpl();
        List<Transaction> transactions = parserService.parse(strings, operationStrategies);

        DataProcessingService dataProcessingService = new DataProcessingServiceImpl();
        dataProcessingService.processTheData(transactions);

        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        List<String> outputStrings = reportGeneratorService.generate();

        File outputFile = new File(FOLDER, OUTPUT_FILE);

        FileWriterService fileWriterService = new CsvFileWriterService();
        fileWriterService.writeReport(outputFile, outputStrings);
    }
}
