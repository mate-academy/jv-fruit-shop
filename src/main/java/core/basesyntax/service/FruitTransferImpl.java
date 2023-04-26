package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class FruitTransferImpl implements FruitTransfer {
    private OperationStrategy operationStrategy;
    private ReadScvService readScvService;

    public FruitTransferImpl(OperationStrategy operationStrategy, ReadScvService readScvService) {
        this.operationStrategy = operationStrategy;
        this.readScvService = readScvService;
    }

    @Override
    public void transfer() {
        List<FruitTransaction> fruitTransactions = readScvService.readFromFileInputCsv();
        for (FruitTransaction fruit : fruitTransactions) {
            operationStrategy.get(fruit.getOperation()).operation(fruit);
        }
    }
}
