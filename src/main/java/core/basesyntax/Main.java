package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitStoreServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.startegy.ActivityHandler;
import core.basesyntax.startegy.ActivityStrategy;
import core.basesyntax.startegy.ActivityType;
import core.basesyntax.startegy.impl.ActivityStrategyImpl;
import core.basesyntax.startegy.impl.AddActivityHandler;
import core.basesyntax.startegy.impl.BalanceActivityHandler;
import core.basesyntax.startegy.impl.PurchaseActivityHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<ActivityType, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(ActivityType.BALANCE, new BalanceActivityHandler(fruitDao));
        activityHandlerMap.put(ActivityType.PURCHASE, new PurchaseActivityHandler(fruitDao));
        activityHandlerMap.put(ActivityType.RETURN, new AddActivityHandler(fruitDao));
        activityHandlerMap.put(ActivityType.SUPPLY, new AddActivityHandler(fruitDao));
        List<String> text = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        if (new ValidatorServiceImpl().isValid(text)) {
            ActivityStrategy activitiesStrategy = new ActivityStrategyImpl(activityHandlerMap);
            List<TransactionDto> transactions = new ArrayList<>();
            Parser parser = new ParserImpl();
            for (int i = 1; i < text.size(); i++) {
                transactions.add(parser.parseLine(text.get(i)));
            }
            List<Fruit> fruits = new FruitStoreServiceImpl(fruitDao, activitiesStrategy)
                    .changeBalance(transactions);
            String report = new CreateReportServiceImpl().createReport(fruits);
            new WriterServiceImpl().writeData(OUTPUT_FILE_PATH, report);
        }
    }
}
