package core.basesyntax;

import core.basesyntax.dao.FruitMapDao;
import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportMakerCsv;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ValidatorCsv;
import core.basesyntax.strategy.AddOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.OperationType;
import core.basesyntax.strategy.RemovingOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitStorageDao fruitDao = new FruitMapDao();

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getOperation(),
                new AddOperation(fruitDao));
        operationHandlerMap.put(OperationType.PURCHASE.getOperation(),
                new RemovingOperation(fruitDao));
        operationHandlerMap.put(OperationType.SUPPLY.getOperation(),
                new AddOperation(fruitDao));
        operationHandlerMap.put(OperationType.RETURN.getOperation(),
                new AddOperation(fruitDao));
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        Reader fileReader = new FileServiceImpl();
        Writer fileWriter = new FileServiceImpl();
        ReportMaker reportMaker = new ReportMakerCsv();
        ShopService shopService = new ShopServiceImpl(strategy);
        List<String> inputData = fileReader.readFrom(INPUT_FILEPATH);
        Validator validator = new ValidatorCsv();
        if (validator.isValidData(inputData)) {
            shopService.updateFruitsWarehouse(inputData);
            String report = reportMaker.makeReport(Storage.map);
            fileWriter.write(report, OUTPUT_FILEPATH);
        }
    }
}
