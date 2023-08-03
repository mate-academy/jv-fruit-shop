package core.basesyntax;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.activity.strategy.ActivityHandler;
import core.basesyntax.service.activity.strategy.BalanceHandler;
import core.basesyntax.service.activity.strategy.PurchaseHandler;
import core.basesyntax.service.activity.strategy.ReturnHandler;
import core.basesyntax.service.activity.strategy.SupplyHandler;
import core.basesyntax.service.impl.ActivitiesProcessorImpl;
import core.basesyntax.service.impl.ActivityStrategyImpl;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopHW {
    private static final String FILE_NAME = "src/main/resources/activities.csv";
    private static final String REPORT_NAME = "src/main/resources/report.csv";
    private static final FileReader CSV_FILE_READER = new CsvFileReader();
    private static final FileWriter CSV_FILE_WRITER = new CsvFileWriter();
    private static final DataParserImpl DATA_PARSE = new DataParserImpl();
    private static final Map<FruitActivity.Type, ActivityHandler> ACTIVITY_HANDLER_MAP =
            new HashMap<>();
    private static final ActivityStrategyImpl ACTIVITY_STRATEGY_IMPL =
            new ActivityStrategyImpl(ACTIVITY_HANDLER_MAP);
    private static final ActivitiesProcessorImpl ACTIVITIES_PROCESSOR_IMPL =
            new ActivitiesProcessorImpl(ACTIVITY_STRATEGY_IMPL);
    private static final ReportGeneratorImpl REPORT_GENERATOR_IMPL = new ReportGeneratorImpl();

    static {
        ACTIVITY_HANDLER_MAP.put(FruitActivity.Type.BALANCE, new BalanceHandler());
        ACTIVITY_HANDLER_MAP.put(FruitActivity.Type.SUPPLY, new SupplyHandler());
        ACTIVITY_HANDLER_MAP.put(FruitActivity.Type.PURCHASE, new PurchaseHandler());
        ACTIVITY_HANDLER_MAP.put(FruitActivity.Type.RETURN, new ReturnHandler());
    }

    public static void main(String[] args) {
        List<String> lines = CSV_FILE_READER.getLinesFromFile(FILE_NAME);
        List<FruitActivity> activities = DATA_PARSE.processFile(lines);
        ACTIVITIES_PROCESSOR_IMPL.processActivities(activities);
        String report = REPORT_GENERATOR_IMPL.generateReport();
        CSV_FILE_WRITER.writeTextToFile(REPORT_NAME, report);
    }
}
