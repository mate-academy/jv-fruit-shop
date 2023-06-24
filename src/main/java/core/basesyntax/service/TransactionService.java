package core.basesyntax.service;

import core.basesyntax.model.FruitsTranslation;
import java.util.List;

public interface TransactionService {
    List<FruitsTranslation> transactionProcess(List<String> transactionData);
}
