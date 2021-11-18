package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.WorkService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.activity.ActivityHandler;
import core.basesyntax.service.activity.AddingHandler;
import core.basesyntax.service.activity.RemovingHandler;
import core.basesyntax.service.activity.TypeActivity;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WorkServiceImpl;
import core.basesyntax.service.impl.WriterCsvImpl;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao);

        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(TypeActivity.BALANCE.toString(), new AddingHandler(fruitService));
        activityHandlerMap.put(TypeActivity.PURCHASE.toString(), new RemovingHandler(fruitDao));
        activityHandlerMap.put(TypeActivity.SUPPLY.toString(), new AddingHandler(fruitService));
        activityHandlerMap.put(TypeActivity.RETURN.toString(), new AddingHandler(fruitService));
        ActivityStrategy strategy = new ActivityStrategyImpl(activityHandlerMap);

        Validator validator = new ValidatorImpl();
        Reader fileReader = new ReaderCsvImpl();
        Writer fileWriter = new WriterCsvImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        ShopService shopService = new ShopServiceImpl(strategy, fruitDao);
        WorkService workService =
                new WorkServiceImpl(fileReader, fileWriter, reportMaker, validator, shopService);
        workService.workShop(INPUT_FILEPATH, OUTPUT_FILEPATH);
    }
}
