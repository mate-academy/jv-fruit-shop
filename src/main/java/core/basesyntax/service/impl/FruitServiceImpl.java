package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationService operationService;

    public FruitServiceImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction item : transactions) {
            Operation type = item.getOperation();
            operationService.getHandler(type).applyChanges(item);
        }
    }
}
