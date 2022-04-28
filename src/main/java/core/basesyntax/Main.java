package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.files.ReadFromFileImpl;
import core.basesyntax.files.WriteToFileImpl;
import core.basesyntax.operation.Activity;
import core.basesyntax.service.GetListForReportImpl;
import core.basesyntax.service.activity.ActivityService;
import core.basesyntax.service.activity.BalanceActivityService;
import core.basesyntax.service.activity.PurchaseActivityService;
import core.basesyntax.service.activity.ReturnActivityService;
import core.basesyntax.service.activity.SupplyActivityService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Activity, ActivityService> activityServiceMap = new HashMap<>();
        activityServiceMap.put(Activity.BALANCE, new BalanceActivityService(new FruitDaoImpl()));
        activityServiceMap.put(Activity.SUPPLY, new SupplyActivityService(new FruitDaoImpl()));
        activityServiceMap.put(Activity.PURCHASE, new PurchaseActivityService(new FruitDaoImpl()));
        activityServiceMap.put(Activity.RETURN, new ReturnActivityService(new FruitDaoImpl()));

        List<String> dataFromFile = new ReadFromFileImpl().readFromFile();

        activityServiceMap.get(Activity.BALANCE).activity(dataFromFile);
        activityServiceMap.get(Activity.SUPPLY).activity(dataFromFile);
        activityServiceMap.get(Activity.PURCHASE).activity(dataFromFile);
        activityServiceMap.get(Activity.RETURN).activity(dataFromFile);

        new WriteToFileImpl().writeToFile(new GetListForReportImpl(new FruitDaoImpl()).getReport());

        System.out.println(Storage.fruits);

    }
}
