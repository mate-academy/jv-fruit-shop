package core.basesyntax.dataconverter;

import core.basesyntax.fruittransaction.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertFromStrings(List<String> data);
}
