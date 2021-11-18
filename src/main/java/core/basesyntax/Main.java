package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.activity.ActivityOperation;
import core.basesyntax.service.activity.DecreasingActivityOperation;
import core.basesyntax.service.activity.IncreasingActivityOperation;
import core.basesyntax.service.activity.TypeActivity;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderCsvImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterCsvImpl;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitBoxDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fruitBoxDao);

        Map<TypeActivity, ActivityOperation> handlerMap = new HashMap<>();
        handlerMap.put(TypeActivity.b, new IncreasingActivityOperation(fruitService));
        handlerMap.put(TypeActivity.p, new DecreasingActivityOperation(fruitBoxDao));
        handlerMap.put(TypeActivity.s, new IncreasingActivityOperation(fruitService));
        handlerMap.put(TypeActivity.r, new IncreasingActivityOperation(fruitService));
        ActivityStrategy strategy = new ActivityStrategyImpl(handlerMap);

        Validator validator = new ValidatorImpl();
        Reader fileReader = new ReaderCsvImpl();
        Writer fileWriter = new WriterCsvImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        List<String> inputData = fileReader.readFromFile(INPUT_FILEPATH);
        ShopService shopService = new ShopServiceImpl(strategy, validator);
        shopService.updatingFruitStorage(inputData);
        Map<String, Long> totalAmount = shopService.amountCalculator(fruitBoxDao.getAll());
        String report = reportMaker.makingReport(totalAmount);
        fileWriter.writeToFile(report, OUTPUT_FILEPATH);
    }
}
