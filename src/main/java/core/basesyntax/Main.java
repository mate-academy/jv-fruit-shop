package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ActivityServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.parser.impl.ParserMapServiceImpl;
import core.basesyntax.service.parser.impl.ParserServiceImpl;
import java.util.List;

public class Main {
    private static final String pathFromFile = "src/main/resources/input_data";
    private static final String pathToFile = "src/main/resources/output_data";

    public static void main(String[] args) {
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(pathFromFile);
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseData(dataFromFile);
        ActivityServiceImpl shopWork = new ActivityServiceImpl();
        shopWork.getAllActivitiesInTheShop(fruitTransactions);
        ParserMapServiceImpl parserMapToString = new ParserMapServiceImpl();
        String stringFromFruitsComposition = parserMapToString.getStringFromFruitsComposition();
        WriterServiceImpl writerService = new WriterServiceImpl();
        writerService.writeReportToCcvFile(stringFromFruitsComposition, pathToFile);
    }
}
