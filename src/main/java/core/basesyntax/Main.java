package core.basesyntax;

import core.basesyntax.dao.ActivityDaoCsvFileImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoMapImpl;
import core.basesyntax.dao.ReportDaoCsvFileImpl;
import core.basesyntax.model.Activity;
import core.basesyntax.service.ActivityServiceImpl;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.ActivityStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.activityhandler.ActivityHandler;
import core.basesyntax.service.activityhandler.BalanceActivityHandler;
import core.basesyntax.service.activityhandler.PurchaseActivityHandler;
import core.basesyntax.service.activityhandler.ReturnActivityHandler;
import core.basesyntax.service.activityhandler.SupplyActivityHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/DailyActivity.csv";
    private static final String OUTPUT_FILE = "src/main/resources/DailyFruitReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoMapImpl();
        Map<Activity.Type, ActivityHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(Activity.Type.b, new BalanceActivityHandler(fruitDao));
        operationStrategies.put(Activity.Type.p, new PurchaseActivityHandler(fruitDao));
        operationStrategies.put(Activity.Type.s, new SupplyActivityHandler(fruitDao));
        operationStrategies.put(Activity.Type.r, new ReturnActivityHandler(fruitDao));

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(operationStrategies);

        ReportService reportService = new ReportServiceImpl(new ActivityDaoCsvFileImpl(INPUT_FILE),
                new FruitDaoMapImpl(), new ReportDaoCsvFileImpl(OUTPUT_FILE),
                new ActivityServiceImpl(activityStrategy));
        reportService.generateReport();
    }
}
