package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.io.FileReader;
import core.basesyntax.service.io.FileReaderImpl;
import core.basesyntax.service.io.FileWriter;
import core.basesyntax.service.io.FileWriterImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.FruitOperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/resources/operations.csv";
    private static final String PATH_TO_REPORT_FILE = "src/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, FruitOperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
        Strategy strategy = new StrategyImpl(operationMap);
        FileReader reader = new FileReaderImpl();
        List<String> list = reader.readeFromFile(PATH_TO_INPUT_FILE);
        ParseService collectData = new ParseServiceImpl();

        for (String data : list.subList(1, list.size())) {
            FruitTransaction fruitTransaction = collectData.parse(data);
            FruitOperationHandler fruitOperation = strategy.get(fruitTransaction.getOperation());
            fruitOperation.handle(fruitTransaction);
        }

        Map<String, Integer> storageMap = fruitDao.getAll();
        ReportCreator generateReport = new ReportCreatorImpl();
        String report = generateReport.create(storageMap);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
