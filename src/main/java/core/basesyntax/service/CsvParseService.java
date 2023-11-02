package core.basesyntax.service;

import core.basesyntax.model.GoodsOperation;
import java.util.List;

public interface CsvParseService {
    List<GoodsOperation> listOperationsFromCsv(List<String> csvOperations);

    GoodsOperation convertToOperationFromCsv(String operation);
}
