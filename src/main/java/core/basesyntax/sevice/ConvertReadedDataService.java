package core.basesyntax.sevice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertReadedDataService {
    List<FruitTransaction> convertDataFromFile(List<String> list);

}
