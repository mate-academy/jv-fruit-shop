package core.basesyntax;

import core.basesyntax.model.Activities;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.serviceimpl.ProcessingServiceImpl;
import core.basesyntax.service.strategy.ActivitiesHandler;
import core.basesyntax.service.strategy.ActivitiesHandlerOfBalance;
import core.basesyntax.service.strategy.ActivitiesHandlerOfPurchase;
import core.basesyntax.service.strategy.ActivitiesHandlerOfReturn;
import core.basesyntax.service.strategy.ActivitiesHandlerOfSupply;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Activities, ActivitiesHandler> activitiesServiceMap = new HashMap<>();
        activitiesServiceMap.put(Activities.BALANCE,
                new ActivitiesHandlerOfBalance());
        activitiesServiceMap.put(Activities.SUPPLY,
                new ActivitiesHandlerOfSupply());
        activitiesServiceMap.put(Activities.PURCHASE,
                new ActivitiesHandlerOfPurchase());
        activitiesServiceMap.put(Activities.RETURN,
                new ActivitiesHandlerOfReturn());

        ProcessingService processingService = new ProcessingServiceImpl(activitiesServiceMap);
        processingService.processReport(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }
}
