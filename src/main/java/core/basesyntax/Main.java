package core.basesyntax;

import core.basesyntax.dao.ActivitiesDao;
import core.basesyntax.dao.ActivitiesDaoCsvImpl;
import core.basesyntax.exceptions.InputException;
import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.ActivityService;
import core.basesyntax.service.ActivityServiceImpl;
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
        List<String> activities = activitiesDao.getActivities(FROM_FILE);

        InputValidator validator = new InputValidatorImpl();
        try {
            validator.validate(activities);
        } catch (InputException e) {
            throw new RuntimeException(e);
        }
        Map<String, Integer> reportStorage;
        ActivityService activityService = new ActivityServiceImpl();
        reportStorage = activityService.processingActivities(activityTypeStrategy, activities);
        activitiesDao.writeReportInFile(TO_FILE, reportStorage);
    }
}
