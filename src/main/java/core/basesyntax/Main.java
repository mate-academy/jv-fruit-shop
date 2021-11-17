package core.basesyntax;

import core.basesyntax.dao.FruitBoxDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import core.basesyntax.strategy.activity.ActivityHandler;
import core.basesyntax.strategy.activity.BalanceActivityHandler;
import core.basesyntax.strategy.activity.PurchaseActivityHandler;
import core.basesyntax.strategy.activity.ReturnActivityHandler;
import core.basesyntax.strategy.activity.SupplyActivityHandler;
import core.basesyntax.validator.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, ActivityHandler> handlerMap = new HashMap<>();
        handlerMap.put(ActivityHandler.BALANCE, new BalanceActivityHandler());
        handlerMap.put(ActivityHandler.PURCHASE, new PurchaseActivityHandler());
        handlerMap.put(ActivityHandler.SUPPLY, new SupplyActivityHandler());
        handlerMap.put(ActivityHandler.RETURN, new ReturnActivityHandler());

        ActivityStrategy strategy = new ActivityStrategyImpl(handlerMap);

        Reader fileReader = new ReaderImpl();
        Writer fileWriter = new WriterImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        List<String> inputData = fileReader.readFromFile(INPUT_FILEPATH);
        FruitServiceImpl fruitService =
                new FruitServiceImpl(new ValidatorImpl(), strategy, new FruitBoxDaoImpl());
        fruitService.updatingFruitBox(inputData);
        String report = reportMaker.makingReport(Storage.storage);
        fileWriter.writeToFile(report, OUTPUT_FILEPATH);
    }
}
