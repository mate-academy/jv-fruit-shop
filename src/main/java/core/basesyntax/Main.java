package core.basesyntax;

import core.basesyntax.db.CurrentData;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.filehandler.ReadFromFile;
import core.basesyntax.service.filehandler.WriteToFile;
import core.basesyntax.service.functionalityexpansion.ActivityTypeEnum;
import core.basesyntax.service.functionalityexpansion.FunctionalityExpansion;
import core.basesyntax.service.parsefileinfo.CurrentStringParse;
import core.basesyntax.service.parsefileinfo.FruitParser;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitParser fruitParser = new FruitParser();
        ShopService shopService = new ShopService(fruitParser);
        CurrentData data = new CurrentData();
        FunctionalityExpansion expansion = new FunctionalityExpansion(data);
        ReadFromFile fileInfo = new ReadFromFile();
        WriteToFile writeToFile = new WriteToFile(data);
        CurrentStringParse currentStringParse = new CurrentStringParse();

        Map<ActivityTypeEnum, ShopActivityStrategy> strategyMap = new HashMap<>();
        expansion.putStrategyByKey(strategyMap);

        String inputFilePath = "src/main/resources/StorageInfo.csv";
        String info = fileInfo.readFromFile(inputFilePath);

        String[] infoAsArray = currentStringParse.parse(info);
        shopService.doStrategy(strategyMap,infoAsArray);
        String reportFilePath = "src/main/resources/StorageReport.csv";
        writeToFile.write(reportFilePath);
    }
}
