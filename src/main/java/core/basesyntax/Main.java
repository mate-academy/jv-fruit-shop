package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.file.writer.FileWriterImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ParserImpl;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.reader.FileReaderImpl;
import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.report.ReportMaker;
import core.basesyntax.report.ReportMakerImpl;
import core.basesyntax.store.*;
import core.basesyntax.store.record.FruitRecordService;
import core.basesyntax.store.record.FruitRecordServiceImpl;
import core.basesyntax.store.strategy.*;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;

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

        Validator validator = new ValidatorImpl();
        FruitRecordService fruitRecordService = new FruitRecordServiceImpl();
        FruitService fruitService = new FruitServiceImpl();
        Parser parser = new ParserImpl(validator, fruitRecordService, fruitService);
        List<FruitRecord> fruitRecordList = parser.parseLines(list);

        Map<OperationType, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(OperationType.B, new BalanceHandler());
        typeHandlerMap.put(OperationType.S, new SupplyHandler());
        typeHandlerMap.put(OperationType.P, new PurchaseHandler());
        typeHandlerMap.put(OperationType.R, new ReturnHandler());
        TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlerMap);
        FruitDao fruitDao = new FruitDaoImpl();
        StorageService storageService = new StorageServiceImpl(typeStrategy, fruitDao);
        List<Fruit> fruits = storageService.getReport(fruitRecordList);

        FileWriter fileWriter = new FileWriterImpl();
        ReportMaker reportMaker = new ReportMakerImpl(fileWriter);
        reportMaker.reportMaker(REPORT_PATH, fruits);
    }
}
