package core.basesyntax.report.convertdata;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface DataConvertor {
    List<FruitOperation> convertToTransaction(List<String> fruitInfoList);
}
