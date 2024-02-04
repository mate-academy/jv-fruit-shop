package core.basesyntax.data;

import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;

import java.util.List;

public interface FileService {
    void saveReport(List<FruitResultingRow> resultingRows);
    List<FruitTransactionRow> getTransactions();
}
