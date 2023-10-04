package core.basesyntax.application;

import core.basesyntax.model.fruit.Operation;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.csv.ReadService;
import core.basesyntax.service.csv.WriteService;
import core.basesyntax.service.csv.impl.CsvReadServiceImpl;
import core.basesyntax.service.csv.impl.CsvWriteServiceImpl;
import core.basesyntax.service.fruit.FruitService;
import core.basesyntax.service.fruit.impl.FruitServiceImpl;
import core.basesyntax.service.parser.ReadParser;
import core.basesyntax.service.parser.WriteParser;
import core.basesyntax.service.parser.impl.CsvReadParserImpl;
import core.basesyntax.service.parser.impl.CsvWriteParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private ReadService readDao;
    private WriteService writeDao;
    private ReadParser readParser;
    private WriteParser writeParser;
    private OperationStrategy strategy;
    private FruitService fruitService;
    private final String inputPath = "src/main/resources/input.csv";
    private final String destinationPath = "src/main/resources/report.csv";

    public void run() {
        initialize();
        List<String> rowsFromFile = readDao.read();
        List<Record> records = readParser.parseFileData(rowsFromFile);
        Map<String, Integer> fruitMap = fruitService.processRecords(records);
        String parsedFruitMap = writeParser.parseProcessedData(fruitMap);
        writeDao.save(parsedFruitMap);
    }

    private void initialize() {
        readParser = new CsvReadParserImpl();
        writeParser = new CsvWriteParserImpl();
        readDao = new CsvReadServiceImpl(inputPath);
        writeDao = new CsvWriteServiceImpl(destinationPath);
        strategy = new OperationStrategy(initializeOperationMap());
        fruitService = new FruitServiceImpl(strategy);
    }

    public Map<Operation, OperationHandler> initializeOperationMap() {
        HashMap<Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceHandler());
        operationMap.put(Operation.SUPPLY, new SupplyHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationMap.put(Operation.RETURN, new ReturnHandler());
        return operationMap;
    }
}
