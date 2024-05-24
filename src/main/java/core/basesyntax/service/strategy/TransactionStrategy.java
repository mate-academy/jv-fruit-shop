package core.basesyntax.service.strategy;

import core.basesyntax.model.OperationModel;
import java.util.List;

public interface TransactionStrategy {
    void transactionOperator(List<OperationModel> list);
}
