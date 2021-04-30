package core.basesyntax;

import core.basesyntax.activity.Activities;
import core.basesyntax.activity.ActivityParserImpl;
import core.basesyntax.activity.ActivityStrategyImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.fruit.dto.FruitDtoParserImpl;
import core.basesyntax.fruitshop.file.reader.TaskReaderImpl;
import core.basesyntax.fruitshop.report.generator.ReportGeneratorImpl;
import core.basesyntax.activity.ActivityParser;
import core.basesyntax.fruit.dto.FruitDtoParser;
import core.basesyntax.storage.dao.HandleGoods;
import core.basesyntax.activity.PickActivityStrategy;
import core.basesyntax.fruitshop.report.generator.ReportGenerator;
import core.basesyntax.fruitshop.file.reader.TaskReader;
import core.basesyntax.storage.dao.AddToStorageImpl;
import core.basesyntax.storage.dao.TakeFromStorageImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ActivityParser activityParser = new ActivityParserImpl();
        FruitDtoParser fruitDtoParser = new FruitDtoParserImpl();
        TaskReader taskReader = new TaskReaderImpl();

        final Map<Activities, HandleGoods> handleGoodsMap = new HashMap<>();
        handleGoodsMap.put(Activities.BALANCE, new AddToStorageImpl());
        handleGoodsMap.put(Activities.SUPPLY, new AddToStorageImpl());
        handleGoodsMap.put(Activities.PURCHASE, new TakeFromStorageImpl());
        handleGoodsMap.put(Activities.RETURN, new AddToStorageImpl());
        PickActivityStrategy activityStrategy = new ActivityStrategyImpl(handleGoodsMap);

        List<String> dataList = taskReader.readFile("src/main/resources/InputFile.csv");
        for (String line : dataList) {
            activityStrategy.get(activityParser.parseActivity(line))
                    .handleGoods(fruitDtoParser.parseFruitDto(line));
        }
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        reportGenerator.generateReport("src/main/resources/Report.csv", Storage.getFruitStorage());
    }
}
