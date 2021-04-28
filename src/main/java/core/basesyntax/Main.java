package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.reader.FileReaderImpl;
import core.basesyntax.report.ReportMaker;
import core.basesyntax.report.ReportMakerImpl;
import core.basesyntax.store.strategy.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FOR_DB_OK =
        "src/main/store/testFilePositive.csv";
    private static final String PATH_FOR_DB_NOT_OK =
            "src/main/store/testFileNegative.csv";
    private static final String REPORT_PATH =
            "src/main/store/report/report.csv";

    public static void main(String[] args) throws IOException {
        FileReader readerService = new FileReaderImpl();
        List<String> list = readerService.read(PATH_FOR_DB_OK);
        Map<String, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put("b", new BalanceHandler());
        typeHandlerMap.put("s", new SupplyHandler());
        typeHandlerMap.put("p", new PurchaseHandler());
        typeHandlerMap.put("r", new ReturnHandler());
        Parser parser = new ParserImpl(typeHandlerMap);
        List<Fruit> fruitList = parser.parseLines(list, typeHandlerMap.keySet());
        ReportMaker reportMaker = new ReportMakerImpl();
        reportMaker.reportMaker(REPORT_PATH, fruitList);
    }
}
