package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessReadDataService;
import core.basesyntax.strategy.CodeService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessReadDataServiceImpl implements ProcessReadDataService {
    private OperationStrategy operationStrategy;

    public ProcessReadDataServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToDB(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            CodeService codeService =
                    operationStrategy.getCodeService(fruitTransaction.getOperation());
            codeService.doOperation(fruitTransaction);
        }
    }
}
