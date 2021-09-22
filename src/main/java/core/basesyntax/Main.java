package core.basesyntax;

import fruitshop.FruitShop;
import fruitshop.FruitShopImpl;
import java.util.HashMap;
import java.util.Map;
import service.ActivitiesStrategy;
import service.ActivitiesStrategyImpl;
import service.activities.ActivityHandler;
import service.activities.BalanceHandler;
import service.activities.PurchaseHandler;
import service.activities.ReturnHandler;
import service.activities.SupplyHandler;
import service.activities.TypeOfActivities;

public class Main {
    public static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
    public static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<TypeOfActivities, ActivityHandler> typeOfActivitiesActivitiesMap = new HashMap<>();
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.BALANCE, new BalanceHandler());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.SUPPLY, new SupplyHandler());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.PURCHASE, new PurchaseHandler());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.RETURN, new ReturnHandler());
        ActivitiesStrategy strategy = new ActivitiesStrategyImpl(typeOfActivitiesActivitiesMap);
        FruitShop fruitShop = new FruitShopImpl(strategy,INPUT_DATA_PATH, REPORT_PATH);
        System.out.println(fruitShop.createNewReport());
    }
}
