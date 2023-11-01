package core.basesyntax.service;

import core.basesyntax.model.GoodsOperation;
import java.util.ArrayList;

public interface CsvParseService {
    ArrayList<GoodsOperation> listOperationsFromCsv(ArrayList<String> csvOperations);

    GoodsOperation convertToOperationFromCsv(String operation);
}
