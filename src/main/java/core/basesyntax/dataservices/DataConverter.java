package core.basesyntax.dataservices;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convert(List<String> transactions);
}
