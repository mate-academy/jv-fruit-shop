package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.List;
import java.util.Map;

public interface PivotDao {
    void writePivotFile(String fileName, List<String> stringList);

    List<String> getBalanceList(Map<Product, Integer> balanceByProduct);
}
