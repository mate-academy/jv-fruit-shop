import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Activity;
import model.ActivityType;
import service.ActivityReaderService;
import service.CsvWriterService;
import service.ReportCreator;
import service.impl.ActivityReaderServiceImpl;
import service.impl.CsvWriterServiceImpl;
import service.impl.ReportCreatorImpl;
import strategy.ActivityTypeHandler;
import strategy.ActivityTypeStrategy;
import strategy.impl.ActivityTypeStrategyImpl;
import strategy.impl.AdditionTypeHandler;
import strategy.impl.PurchaseTypeHandler;

public class Main {
    private static final String FROM_FILE_NAME = "src/files/fruit.csv";
    private static final String TO_FILE_NAME = "src/files/report.csv";

    public static void main(String[] args) {
        ActivityReaderService activityReaderService = new ActivityReaderServiceImpl();
        final List<Activity> activityList = activityReaderService.readFromFile(FROM_FILE_NAME);

        Map<String, Integer> fruitBox = new HashMap<>();
        fruitBox.put("apple", 0);
        fruitBox.put("banana", 0);
        Storage storage = new Storage(fruitBox);

        Map<ActivityType, ActivityTypeHandler> activityTypeHandlerMap = new HashMap<>();
        activityTypeHandlerMap.put(ActivityType.BALANCE, new AdditionTypeHandler());
        activityTypeHandlerMap.put(ActivityType.SUPPLY, new AdditionTypeHandler());
        activityTypeHandlerMap.put(ActivityType.RETURN, new AdditionTypeHandler());
        activityTypeHandlerMap.put(ActivityType.PURCHASE, new PurchaseTypeHandler());

        ActivityTypeStrategy activityTypeStrategy = new ActivityTypeStrategyImpl(
                activityTypeHandlerMap);

        for (Activity activity : activityList) {
            storage.getFruitBox().put(activity.getFruit(), activityTypeStrategy
                    .get(activity.getType())
                    .getNewQuantity(storage.getFruitBox()
                            .get(activity.getFruit()), activity.getQuantity()));
        }

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(storage);

        CsvWriterService csvWriterService = new CsvWriterServiceImpl();
        csvWriterService.writeToFile(TO_FILE_NAME, report);
    }
}
