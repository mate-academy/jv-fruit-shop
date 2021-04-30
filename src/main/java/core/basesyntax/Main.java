package core.basesyntax;

import core.basesyntax.activity.Activities;
import core.basesyntax.activity.ActivityParser;
import core.basesyntax.activity.ActivityParserImpl;
import core.basesyntax.activity.ActivityStrategy;
import core.basesyntax.activity.ActivityStrategyImpl;
import core.basesyntax.fruit.dto.FruitDtoParser;
import core.basesyntax.fruit.dto.FruitDtoParserImpl;
import core.basesyntax.fruitshop.file.reader.FileReader;
import core.basesyntax.fruitshop.file.reader.FileReaderImpl;
import core.basesyntax.fruitshop.report.generator.FileWriter;
import core.basesyntax.fruitshop.report.generator.FileWriterImpl;
import core.basesyntax.fruitshop.report.generator.ReportGeneratorImpl;
import core.basesyntax.storage.dao.AddToStorageHandlerImpl;
import core.basesyntax.storage.dao.StorageHandler;
import core.basesyntax.storage.dao.TakeFromStorageHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ActivityParser activityParser = new ActivityParserImpl();
        FruitDtoParser fruitDtoParser = new FruitDtoParserImpl();
        FileReader fileReader = new FileReaderImpl();

        Map<Activities, StorageHandler> handleGoodsMap = new HashMap<>();
        handleGoodsMap.put(Activities.BALANCE, new AddToStorageHandlerImpl());
        handleGoodsMap.put(Activities.SUPPLY, new AddToStorageHandlerImpl());
        handleGoodsMap.put(Activities.PURCHASE, new TakeFromStorageHandlerImpl());
        handleGoodsMap.put(Activities.RETURN, new AddToStorageHandlerImpl());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(handleGoodsMap);

        List<String> dataList = fileReader.read("src/main/resources/InputFile.csv");
        for (String line : dataList) {
            if (!line.equals(dataList.get(0))) {
                activityStrategy.get(activityParser.parseActivity(line))
                        .handleGoods(fruitDtoParser.parseFruitDto(line));
            }
        }
        FileWriter reportWriter = new FileWriterImpl();
        reportWriter.writeReport(new ReportGeneratorImpl().generateReport(),
                "src/main/resources/Report.csv");
    }
}
