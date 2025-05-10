package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.ArrayList;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitStorage> process(List<FruitTransaction> transactions) {

        List<FruitStorage> fruitStorages = new ArrayList<>();

        for (FruitTransaction t : transactions) {
            if (t.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
                OperationHandler strategy = operationStrategy.strategy(t.getOperation());
                FruitStorage startDayCondition = strategy.operation(
                        t, new FruitStorage(t.getFruit(), 0));
                fruitStorages.add(startDayCondition);
            }
        }

        for (FruitTransaction t : transactions) {
            for (FruitStorage s : fruitStorages) {
                if (t.getFruit().equals(s.getFruit()) && !t.getOperation()
                        .equals(FruitTransaction.Operation.BALANCE)) {
                    OperationHandler strategy = operationStrategy.strategy(t.getOperation());
                    s = strategy.operation(t, s);
                }
            }
        }
        return fruitStorages;
    }
}
