package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.csv.reader.ReaderService;
import core.basesyntax.csv.reader.ReaderServiceImpl;
import core.basesyntax.report.ReportMaker;
import core.basesyntax.report.ReportMakerImpl;
import core.basesyntax.store.strategy.*;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final String PATH_FOR_DB_OK =
        "src/main/store/testFilePositive.csv";
    private static final String PATH_FOR_DB_NOT_OK =
            "src/main/store/testFileNegative.csv";
    private static final String REPORT_PATH =
            "src/main/store/report/report.csv";

    static Parser parser;
    static ReportMaker reportMaker;

    public static void main(String[] args) throws IOException {
        ReaderService readerService = new ReaderServiceImpl();
        List<String[]> list = readerService.readFromFile(PATH_FOR_DB_OK);
        Set<String> set = new HashSet<>();
        set.add("b");
        set.add("p");
        set.add("s");
        set.add("r");
        Map<String, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put("b", new BalanceHandler());
        typeHandlerMap.put("s", new SupplyHandler());
        typeHandlerMap.put("p", new PurchaseHandler());
        typeHandlerMap.put("r", new ReturnHandler());
        parser = new ParserImpl(typeHandlerMap);
        List<Fruit> fruitList = parser.parseLines(list, set);
        reportMaker = new ReportMakerImpl();
        reportMaker.reportMaker(REPORT_PATH, fruitList);
    }
}
