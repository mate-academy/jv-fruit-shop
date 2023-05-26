package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActivityService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ActivityServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.parser.ParserMapService;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.parser.impl.ParserMapServiceImpl;
import core.basesyntax.service.parser.impl.ParserServiceImpl;
import java.util.List;

public class Main {
    private static final String pathFromFile = "src/main/resources/input_data";
    private static final String pathToFile = "src/main/resources/report";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(pathFromFile);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseData(dataFromFile);
        ActivityService activityService = new ActivityServiceImpl();
        activityService.getAllActivitiesInTheShop(fruitTransactions);
        ParserMapService parserMapToString = new ParserMapServiceImpl();
        String reportFromFruitStorage = parserMapToString.getStringFromFruitStorage();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReportToCcvFile(reportFromFruitStorage, pathToFile);
    }
}
