import db.Storage;
import db.StorageFiller;
import db.StorageFillerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Activity;
import model.ActivityType;
import service.ActivityParserService;
import service.CsvReaderService;
import service.CsvWriterService;
import service.ReportCreator;
import service.impl.ActivityParserServiceImpl;
import service.impl.CsvReaderServiceImpl;
import service.impl.CsvWriterServiceImpl;
import service.impl.ReportCreatorImpl;
import strategy.ActivityTypeHandler;
import strategy.ActivityTypeStrategy;
import strategy.impl.ActivityTypeStrategyImpl;
import strategy.impl.AdditionTypeHandler;
import strategy.impl.BalanceTypeHandler;
import strategy.impl.PurchaseTypeHandler;

public class Main {
    private static final String FROM_FILE_NAME = "src/files/fruit.csv";
    private static final String TO_FILE_NAME = "src/files/report.csv";

    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderServiceImpl();
        ActivityParserService activityParserService = new ActivityParserServiceImpl();
        final List<Activity> activityList = activityParserService
                .getActivityList(
                        csvReaderService.readFromFile(FROM_FILE_NAME)
                );

        Map<String, Integer> fruitBox = new HashMap<>();
        final Storage storage = new Storage(fruitBox);

        Map<ActivityType, ActivityTypeHandler> activityTypeHandlerMap = new HashMap<>();
        activityTypeHandlerMap.put(ActivityType.BALANCE, new BalanceTypeHandler());
        activityTypeHandlerMap.put(ActivityType.SUPPLY, new AdditionTypeHandler());
        activityTypeHandlerMap.put(ActivityType.RETURN, new AdditionTypeHandler());
        activityTypeHandlerMap.put(ActivityType.PURCHASE, new PurchaseTypeHandler());

        ActivityTypeStrategy activityTypeStrategy = new ActivityTypeStrategyImpl(
                activityTypeHandlerMap);

        StorageFiller storageFiller = new StorageFillerImpl();
        storageFiller.fullfillStorage(storage, activityList, activityTypeStrategy);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(storage);

        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.writeToFile(TO_FILE_NAME, report);
    }
}
