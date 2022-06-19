package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.util.Map;

public interface BalanceService {
    Map<Product, Integer> getBalance();

    void exportPivotToFile(String pivotFileName);
}
