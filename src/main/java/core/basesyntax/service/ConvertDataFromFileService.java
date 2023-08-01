package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertDataFromFileService {
    List<FruitTransaction> convert(String rawData);
}
