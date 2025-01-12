package core.basesyntax.model.convertor;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConvertor {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
