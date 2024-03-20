package core.basesyntax.service;

import core.basesyntax.service.functionalityexpansion.ActivityTypeEnum;
import core.basesyntax.service.parsefileinfo.FruitInfo;
import core.basesyntax.service.parsefileinfo.FruitParser;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import java.util.Map;

public class ShopService {
    private final FruitParser fruitParser;

    public ShopService(FruitParser fruitParser) {
        this.fruitParser = fruitParser;
    }

    public void doStrategy(Map<ActivityTypeEnum, ShopActivityStrategy> strategyMap,
                           String[] fileInfoArr) {
        for (String activityString : fileInfoArr) {
            FruitInfo fruitInfo = fruitParser.parseActivity(activityString);
            ShopActivityStrategy strategy = strategyMap.get(fruitInfo.activityType());
            strategy.workWithActivities(fruitInfo.name(), fruitInfo.quantity());
        }
    }
}
