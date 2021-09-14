import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderCsvImpl;
import core.basesyntax.dao.WriteReport;
import core.basesyntax.dao.WriteReportImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.services.CommandParser;
import core.basesyntax.services.CommandParserImpl;
import core.basesyntax.services.CountingActivitiesService;
import core.basesyntax.services.CountingActivitiesServiceImpl;
import core.basesyntax.services.FruitStrategy;
import core.basesyntax.services.FruitStrategyImpl;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.ReportServiceImpl;
import core.basesyntax.services.handlers.BalanceFruitHandler;
import core.basesyntax.services.handlers.DecreaseFruitHandler;
import core.basesyntax.services.handlers.FruitHandler;
import core.basesyntax.services.handlers.IncreaseFruitHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src\\main\\resources\\inputFile.csv";
    private static final String REPORT_FILE = "src\\main\\resources\\reportFile.csv";
    private static final String TITLE_REPORT = "fruit, quantity";

    public static void main(String[] args) {
        Map<String, FruitHandler> fruitStrategyMap = new HashMap<>();
        fruitStrategyMap.put(Operation.TypeOperation.RETURN.getType(),
                new IncreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.SUPPLY.getType(),
                new IncreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.PURCHASE.getType(),
                new DecreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.BALANCE.getType(),
                new BalanceFruitHandler());
        FileReader fileReaderCsv = new FileReaderCsvImpl();
        List<String> inputData = fileReaderCsv.getData(INPUT_FILE);
        CommandParser commandParser = new CommandParserImpl();
        List<Operation> operations = commandParser.parseData(inputData);
        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruitStrategyMap);
        CountingActivitiesService countingService = new CountingActivitiesServiceImpl();
        Map<String, Integer> result = countingService.countingActivities(operations, fruitStrategy);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(result, TITLE_REPORT);
        WriteReport writeReport = new WriteReportImpl();
        writeReport.write(report, REPORT_FILE);
    }
}

