package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.io.ReadFromFile;
import core.basesyntax.service.io.ReadFromFileImpl;
import core.basesyntax.service.io.WriteToFile;
import core.basesyntax.service.io.WriteToFileImpl;
import core.basesyntax.service.operation.FruitBalance;
import core.basesyntax.service.operation.FruitOperationHandler;
import core.basesyntax.service.operation.FruitPurchase;
import core.basesyntax.service.operation.FruitReturn;
import core.basesyntax.service.operation.FruitSupply;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mane {
    private static final String PATH_TO_INPUT_FILE = "src/resources/operations.csv";
    private static final String PATH_TO_REPORT_FILE = "src/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();

        Map<FruitTransaction.Operation, FruitOperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new FruitBalance(fruitDao));
        operationMap.put(FruitTransaction.Operation.SUPPLY, new FruitSupply(fruitDao));
        operationMap.put(FruitTransaction.Operation.PURCHASE, new FruitPurchase(fruitDao));
        operationMap.put(FruitTransaction.Operation.RETURN, new FruitReturn(fruitDao));
        Strategy strategy = new StrategyImpl(operationMap);
        ReadFromFile reader = new ReadFromFileImpl();
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
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
