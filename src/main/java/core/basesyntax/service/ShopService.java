package core.basesyntax.service;

import core.basesyntax.service.filehandler.ReadFromFile;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import java.util.Map;

public class ShopService {
    private final ReadFromFile fileInfo = new ReadFromFile();
    private final String filePath = "src/main/resources/StorageInfo.csv";
    private final String info = fileInfo.readFromFile(filePath);
    private final String[] fileInfoArr = info.split("[\\r\\n\\s]+");

    public void doStrategy(Map<String, ShopActivityStrategy> strategyMap) {
        for (int i = 0; i < fileInfoArr.length; i++) {
            String[] activityTypeArray = fileInfoArr[i].split(",");
            String activityType = activityTypeArray[0];
            String fruit = activityTypeArray[1];
            int quantity = Integer.parseInt(activityTypeArray[2]);
            ShopActivityStrategy strategy = strategyMap.get(activityType);
            strategy.workWithActivities(fruit, quantity);
        }
    }
}
