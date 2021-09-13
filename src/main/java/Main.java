import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoCsvImpl;
import core.basesyntax.dao.WriteReport;
import core.basesyntax.dao.WriteReportImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.services.CountingActivitiesService;
import core.basesyntax.services.CountingActivitiesServiceImpl;
import core.basesyntax.services.FormattedData;
import core.basesyntax.services.FormattedDataImpl;
import core.basesyntax.services.FruitStrategy;
import core.basesyntax.services.FruitStrategyImpl;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.ReportServiceImpl;
import core.basesyntax.services.handlers.DecreaseFruitHandler;
import core.basesyntax.services.handlers.FruitHandler;
import core.basesyntax.services.handlers.IncreaseFruitHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src\\main\\resources\\inputFile.csv";
    private static final String REPORT_FILE = "src\\main\\resources\\reportFile.csv";

    public static void main(String[] args) {
        Map<String, FruitHandler> fruitStrategyMap = new HashMap<>();
        fruitStrategyMap.put(Operation.TypeOperation.RETURN.getType(),
                new IncreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.SUPPLY.getType(),
                new IncreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.PURCHASE.getType(),
                new DecreaseFruitHandler());
        fruitStrategyMap.put(Operation.TypeOperation.BALANCE.getType(),
                new IncreaseFruitHandler());
        FruitDao fruitDaoCsv = new FruitDaoCsvImpl(INPUT_FILE);
        List<String> inputData = fruitDaoCsv.getData();
        FormattedData formattedData = new FormattedDataImpl();
        List<Operation> operations = formattedData.formattedData(inputData);
        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruitStrategyMap);
        CountingActivitiesService countingService = new CountingActivitiesServiceImpl();
        Map<String, Integer> result = countingService.countingActivities(operations, fruitStrategy);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(result);
        WriteReport writeReport = new WriteReportImpl(REPORT_FILE);
        writeReport.write(report);
    }
}

