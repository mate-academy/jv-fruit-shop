package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.ArrayList;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private static final FruitStorage EMPTY_STORAGE = new FruitStorage("empty", 0);
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
                FruitStorage startDayCondition = strategy.operation(t, EMPTY_STORAGE);
                fruitStorages.add(startDayCondition);
            }
            for (int i = 0; i < fruitStorages.size(); i++) {
                FruitStorage s = fruitStorages.get(i);
                if (t.getFruit().equals(s.getFruit())) {
                    OperationHandler strategy = operationStrategy.strategy(t.getOperation());
                    fruitStorages.set(i, strategy.operation(t, s));
                }
            }
        }
        return fruitStorages;
    }
}
