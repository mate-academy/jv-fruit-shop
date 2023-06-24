package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CalculatorService {
    void calculate(List<FruitTransaction> transactionList);
}
