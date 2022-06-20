package core.basesyntax.service;

import core.basesyntax.model.TransactionInfo;
import java.util.List;

public interface FruitService {
    void process(List<TransactionInfo> transferFruitList);
}
