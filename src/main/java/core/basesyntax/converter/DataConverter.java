package core.basesyntax.converter;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface DataConverter {

    List<FruitTransaction> convertDataFromInputCsvFile(List<String> inputData);

}
