package core.basesyntax.service;

import core.basesyntax.model.FruitInfo;
import java.util.List;

public interface Convert {
    List<FruitInfo> convertToJavaObject(List<String> dataFileList);
}
