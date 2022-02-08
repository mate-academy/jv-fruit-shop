package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoCsvImpl;
import core.basesyntax.service.BatchLoader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.activitiy.ActivityHandler;
import core.basesyntax.service.activitiy.ActivityType;
import core.basesyntax.service.activitiy.AddingHandler;
import core.basesyntax.service.activitiy.RemovingHandler;
import core.basesyntax.service.impl.BatchLoaderImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.ValidatorCsvImpl;
import core.basesyntax.service.impl.WriterCsvImpl;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(ActivityType.BALANCE.getLetter(), new AddingHandler());
        activityHandlerMap.put(ActivityType.SUPPLY.getLetter(), new AddingHandler());
        activityHandlerMap.put(ActivityType.RETURN.getLetter(), new AddingHandler());
        activityHandlerMap.put(ActivityType.PURCHASE.getLetter(), new RemovingHandler());

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activityHandlerMap);
        StorageDao storageDao = new StorageDaoCsvImpl();

        Reader reader = new ReaderCsvImpl();
        Validator validator = new ValidatorCsvImpl(activityHandlerMap);
        BatchLoader batchLoader = new BatchLoaderImpl(storageDao, activitiesStrategy);
        ReportMaker reportMaker = new ReportMakerImpl();
        Writer writer = new WriterCsvImpl();
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(reader, validator, batchLoader,
                        storageDao, reportMaker, writer);

        String inputFilePath = "src/main/resources/input_database.csv";
        String outputFilePath = "src/main/resources/output_database.csv";
        fruitShopService.runShop(inputFilePath, outputFilePath);
    }
}
