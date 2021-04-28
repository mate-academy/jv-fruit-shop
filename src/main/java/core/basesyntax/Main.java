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
import core.basesyntax.store.*;
import core.basesyntax.store.strategy.*;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import core.basesyntax.validator.length.LineLengthValidator;
import core.basesyntax.validator.length.LineLengthValidatorImpl;
import core.basesyntax.validator.quantity.QuantityValidator;
import core.basesyntax.validator.quantity.QuantityValidatorImpl;
import core.basesyntax.validator.type.TypeValidator;
import core.basesyntax.validator.type.TypeValidatorImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FOR_DB_OK =
            "src/main/resources/testFilePositive.csv";
    private static final String PATH_FOR_DB_NOT_OK =
            "src/main/resources/testFileNegative.csv";
    private static final String REPORT_PATH =
            "src/main/resources/report/report.csv";

    public static void main(String[] args) {
        FileReader readerService = new FileReaderImpl();
        List<String> list = readerService.read(PATH_FOR_DB_OK);
        LineLengthValidator lineLengthValidator = new LineLengthValidatorImpl();
        QuantityValidator quantityValidator = new QuantityValidatorImpl();
        TypeValidator typeValidator = new TypeValidatorImpl();
        Validator validator = new ValidatorImpl(lineLengthValidator,
                typeValidator, quantityValidator);
        Parser parser = new ParserImpl(validator);
        List<FruitRecord> fruitRecordList = parser.parseLines(list);

        FruitDao fruitDao = new FruitDaoImpl();
        Map<OperationType, TypeHandler> typeHandlerMap = new HashMap<>();
        typeHandlerMap.put(OperationType.B, new BalanceHandler(fruitDao));
        typeHandlerMap.put(OperationType.S, new SupplyHandler(fruitDao));
        typeHandlerMap.put(OperationType.P, new PurchaseHandler(fruitDao,
                quantityValidator));
        typeHandlerMap.put(OperationType.R, new ReturnHandler(fruitDao));

        TypeStrategy typeStrategy = new TypeStrategyImpl(typeHandlerMap);
        StorageService storageService = new StorageServiceImpl(typeStrategy, fruitDao);
        List<Fruit> fruits = storageService.saveData(fruitRecordList);
        String report = storageService.getReport(fruits);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(REPORT_PATH, report);
    }
}
