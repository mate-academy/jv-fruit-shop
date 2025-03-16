package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionImpl;
import java.util.List;

public interface DataConverter {
    List<FruitTransactionImpl> convertToTransaction(List<String> inputReport);

    FruitTransactionImpl.Operation getOperationByCode(String code);
}
