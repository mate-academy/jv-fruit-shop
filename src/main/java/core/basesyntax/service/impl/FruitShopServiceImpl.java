package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.nio.file.Path;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transaction(Path csvFile) {
        CsvFileReader fileReader = new CsvFileReaderImpl();
        List<FruitTransaction> fruitTransactions = fileReader.readFile(csvFile);
        fruitTransactions.forEach(l -> operationStrategy
                .getOperation(l.getOperation())
                .operate(l));
    }
}
