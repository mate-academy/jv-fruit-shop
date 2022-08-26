package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitShop {
    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        StorageDao storageDao = new StorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl(storageDao);

        Map<FruitOperation.Operation, CalculateOperation> operationCalculateMap = new HashMap<>();
        operationCalculateMap.put(FruitOperation.Operation.SUPPLY,
                new SupplyOperationImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.PURCHASE,
                new PurchaseOperationImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.RETURN,
                new ReturnOperationImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.BALANCE,
                new BalanceOperationImpl(fruitService));

        Strategy strategy = new StrategyImpl(operationCalculateMap);
        DataFileParser<FruitOperation> operationDataFileParser = new DataFileParserImpl();
        List<String> data = fileReaderService.readFromFile(INPUT_DATA_FILE);
        List<FruitOperation> fruitOperations = operationDataFileParser.parseDataFile(data);
        fruitOperations.stream().forEach(System.out::println);

        for (FruitOperation fruitOperation : fruitOperations) {
            strategy.get(fruitOperation.getOperation()).getCalculateFruit(fruitOperation);
        }

        FruitReport report = new FruitReportImpl(fruitService);
        String reportByDay = report.makeReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_DATA_FILE,reportByDay);
    }
}
