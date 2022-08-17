package core.basesyntax.service.fruittransactionservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionOperation {
    List<FruitTransaction> convertDataToFruitTransaction(List<String> data);
}
