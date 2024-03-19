package core.basesyntax;

import core.basesyntax.db.ChangedData;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.filehandler.WriteToFile;
import core.basesyntax.service.functionalityexpansion.FunctionalityExpansion;
import core.basesyntax.service.functionalityexpansion.FunctionalityExpansionImpl;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        ChangedData data = new ChangedData();
        FunctionalityExpansion expansion = new FunctionalityExpansionImpl(data);
        WriteToFile writeToFile = new WriteToFile(data);

        Map<String, ShopActivityStrategy> strategyMap = new HashMap<>();
        expansion.putStrategyByKey(strategyMap);

        shopService.doStrategy(strategyMap);
        String reportFilePath = "src/main/resources/StorageReport.csv";
        writeToFile.write(reportFilePath);
    }
}
