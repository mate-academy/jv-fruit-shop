package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";
    private static final ReadService csvFileReader = new ReadServiceImpl();
    private static final ParseService fruitTransactionParser = new ParseServiceImpl();
    private static final OperationStrategy operationStrategy = new OperationStrategyImpl();
    private static final FruitShopService fruitShopService =
            new FruitShopServiceImpl(operationStrategy);
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriteService csvFileWriter = new WriteServiceImpl();

    public static void main(String[] args) {
        List<String> stringFromFile = csvFileReader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(stringFromFile);
        fruitShopService.processData(fruitTransactions);
        String report = reportService.generateReport();
        csvFileWriter.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
