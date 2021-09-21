package core.basesyntax;

import core.basesyntax.dao.ActivitiesDao;
import core.basesyntax.dao.ActivitiesDaoCsvImpl;
import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.ActivitiesService;
import core.basesyntax.service.ActivitiesServiceImpl;
import core.basesyntax.service.ActivityTypeStrategy;
import core.basesyntax.service.ActivityTypeStrategyImpl;
import core.basesyntax.service.activityhandler.ActivityTypeHandler;
import core.basesyntax.service.activityhandler.BalanceActivityHandler;
import core.basesyntax.service.activityhandler.PurchaseActivityHandler;
import core.basesyntax.service.activityhandler.ReturnActivityHandler;
import core.basesyntax.service.activityhandler.SupplyActivityHandler;
import core.basesyntax.service.validators.InputValidator;
import core.basesyntax.service.validators.InputValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE = "activities.csv";
    public static final String TO_FILE = "report.csv";

    public static void main(String[] args) {
        BalanceActivityHandler balanceActivityHandler = new BalanceActivityHandler();
        SupplyActivityHandler supplyActivityHandler = new SupplyActivityHandler();
        PurchaseActivityHandler purchaseActivityHandler = new PurchaseActivityHandler();
        ReturnActivityHandler returnActivityHandler = new ReturnActivityHandler();
        Map<ActivitiesType, ActivityTypeHandler> activityTypeHandlerMap = new HashMap<>();
        activityTypeHandlerMap.put(ActivitiesType.b, balanceActivityHandler);
        activityTypeHandlerMap.put(ActivitiesType.s, supplyActivityHandler);
        activityTypeHandlerMap.put(ActivitiesType.p, purchaseActivityHandler);
        activityTypeHandlerMap.put(ActivitiesType.r, returnActivityHandler);
        ActivityTypeStrategy activityTypeStrategy =
                new ActivityTypeStrategyImpl(activityTypeHandlerMap);
        ActivitiesDao activitiesDao = new ActivitiesDaoCsvImpl();
        InputValidator validator = new InputValidatorImpl();
        ActivitiesService activitiesService = new ActivitiesServiceImpl(validator);
        List<String> activities = activitiesDao.getActivities(FROM_FILE);
        activitiesService.processingActivities(activityTypeStrategy, activities);
        activitiesDao.writeInFile(TO_FILE);
    }
}
