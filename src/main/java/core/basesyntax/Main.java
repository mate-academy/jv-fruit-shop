package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.reader.FileReaderImpl;
import core.basesyntax.report.ReportMaker;
import core.basesyntax.report.ReportMakerImpl;
import core.basesyntax.store.StorageService;
import core.basesyntax.store.StorageServiceImpl;
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
        Map<OperationType, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(OperationType.B, new BalanceHandler());
        typeHandlerMap.put(OperationType.S, new SupplyHandler());
        typeHandlerMap.put(OperationType.P, new PurchaseHandler());
        typeHandlerMap.put(OperationType.R, new ReturnHandler());
        Parser parser = new ParserImpl();
        List<FruitRecord> fruitRecordList = parser.parseLines(list);
        StorageService storageService = new StorageServiceImpl(typeHandlerMap);
        List<Fruit> fruits = storageService.getReport(fruitRecordList);
        ReportMaker reportMaker = new ReportMakerImpl();
        reportMaker.reportMaker(REPORT_PATH, fruits);
    }
}
