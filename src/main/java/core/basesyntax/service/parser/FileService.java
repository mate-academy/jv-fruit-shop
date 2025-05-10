package core.basesyntax.service.parser;

import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import java.util.List;

public interface FileService {
    List<String> reportObjectsToStrings(List<FruitResultingRow> resultingRows);

    List<FruitTransactionRow> parseTransactions(List<String> fileLines);
}
