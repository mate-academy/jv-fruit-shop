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
import core.basesyntax.services.handlers.FruitHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src\\main\\resources\\inputFile.csv";
    private static final String REPORT_FILE = "src\\main\\resources\\reportFile.csv";

    public static void main(String[] args) {
        FruitDao fruitDaoCsv = new FruitDaoCsvImpl(INPUT_FILE);
        List<String> inputData = fruitDaoCsv.getData();
        FormattedData formattedData = new FormattedDataImpl();
        List<Operation> operations = formattedData.formattedData(inputData);
        FruitStrategy fruitStrategy = new FruitStrategyImpl();
        Map<String, FruitHandler> fruitHandlerMap = fruitStrategy.create();
        CountingActivitiesService countingService = new CountingActivitiesServiceImpl();
        Map<String, Integer> countingMap = countingService.countingActivities(operations,
                fruitHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.createReport(countingMap);
        WriteReport writeReport = new WriteReportImpl(REPORT_FILE);
        writeReport.write(report);
    }
}

