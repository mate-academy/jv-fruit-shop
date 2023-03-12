package core.basesyntax.service.impl;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void applyFruitTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(operationStrategy::processOperation);
    }

    public void createResultFile(String report, String filePath) {
        if (report == null || report.isBlank()) {
            throw new IllegalArgumentException("Input data is not correct");
        }
        WriterService writerService = new FileWriterServiceImpl();
        writerService.write(report, filePath);
    }
}
