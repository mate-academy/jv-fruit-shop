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
import core.basesyntax.service.activitiy.BalanceHandler;
import core.basesyntax.service.activitiy.PurchaseHandler;
import core.basesyntax.service.activitiy.ReturnHandler;
import core.basesyntax.service.activitiy.SupplyHandler;
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
        Map<ActivityType, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(ActivityType.b, new BalanceHandler());
        activityHandlerMap.put(ActivityType.s, new SupplyHandler());
        activityHandlerMap.put(ActivityType.r, new ReturnHandler());
        activityHandlerMap.put(ActivityType.p, new PurchaseHandler());

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activityHandlerMap);
        StorageDao storageDao = new StorageDaoCsvImpl();

        Reader reader = new ReaderCsvImpl();
        Validator validator = new ValidatorCsvImpl(activityHandlerMap);
        BatchLoader batchLoader = new BatchLoaderImpl(storageDao, activitiesStrategy);
        ReportMaker reportMaker = new ReportMakerImpl(storageDao);
        Writer writer = new WriterCsvImpl();
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(reader, validator, batchLoader,
                        storageDao, reportMaker, writer);

        fruitShopService.runShop();
    }
}
