package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessing {

    List<FruitTransaction> convertDataIntoTransaction(List<String> dataList);
}
