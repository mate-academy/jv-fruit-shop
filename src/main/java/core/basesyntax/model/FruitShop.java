package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private final Map<Operation, OperationStrategy> strategyMap;

    public FruitShop(Map<Operation, OperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Map<Operation, OperationStrategy> getStrategyMap() {
        return strategyMap;
    }

    public void generateBalance(String sourceFilePath) {
        FruitService fruitService = new FruitServiceImpl(strategyMap);
        List<Transaction> transactions = new CsvFileReaderService().readFromFile(sourceFilePath);
        fruitService.applyOperation(transactions);
    }

    public void generateReport(String destFilePath) {
        CsvFileWriterService csvFileService = new CsvFileWriterService();
        csvFileService.writeToFile(Storage.balance, destFilePath);
    }
}
