package core.basesyntax.converter;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface DataConverter {

    List<FruitTransaction> convertFromCsv(List<String> inputData);

}
