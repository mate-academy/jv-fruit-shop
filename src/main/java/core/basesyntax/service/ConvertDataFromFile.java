package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertDataFromFile {
    List<FruitTransaction> convertDataFromFile(List<String> inputList);
}
