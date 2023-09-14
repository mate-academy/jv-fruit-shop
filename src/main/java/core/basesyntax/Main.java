package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.impl.OperationStrategyImpl;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";
    private static final ReaderService csvFileReader = new ReaderServiceImpl();
    private static final ParserService fruitTransactionParser = new ParseServiceImpl();
    private static final OperationStrategy operationStrategy = new OperationStrategyImpl();
    private static final FruitShopService fruitShopService =
            new FruitShopServiceImpl(operationStrategy);
    private static final ReportMakerService reportMakerService = new ReportMakerServiceImpl();
    private static final WriterService csvFileWriter = new WriterServiceImpl();

    public static void main(String[] args) throws IOException {
        List<String> stringsFromFile = csvFileReader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> transactions = fruitTransactionParser.parse(stringsFromFile);
        fruitShopService.processData(transactions);
        String report = reportMakerService.generateReport();
        csvFileWriter.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
