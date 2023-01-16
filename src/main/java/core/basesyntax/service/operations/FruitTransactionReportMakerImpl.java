package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionReportMakerImpl implements FruitTransactionReportMaker {
    private OperationStrategy operationStrategy;

    public FruitTransactionReportMakerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> makeReport(FruitDao dao) {
        List<FruitTransaction> balanceList = dao.getByOperation("b");
        operationStrategy.get(FruitTransaction.Operation.SUPPLY).handle(balanceList);
        operationStrategy.get(FruitTransaction.Operation.PURCHASE).handle(balanceList);
        operationStrategy.get(FruitTransaction.Operation.RETURN).handle(balanceList);
        return balanceList;
    }
}
