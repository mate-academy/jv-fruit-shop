package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Convert {
    List<FruitTransaction> convertToJavaObject(List<String> dataFileList);
}
