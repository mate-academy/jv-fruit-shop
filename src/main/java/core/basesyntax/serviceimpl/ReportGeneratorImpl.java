package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private final HashMap<Operation, OperationStrategy> handlerMap;

    public ReportGeneratorImpl(HashMap<Operation, OperationStrategy> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void generateReport(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> handlerMap.get(t.getOperation())
                .makeFruitTransactionOperation(t));
    }
}
