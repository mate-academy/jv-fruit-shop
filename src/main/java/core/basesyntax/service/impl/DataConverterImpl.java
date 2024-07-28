package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputList) {
        inputList.remove(0);
        return inputList.stream()
                 .map(s -> s.split(","))
                 .map(s -> new FruitTransaction(FruitTransaction.Operation.getFromChar(s[0]),
                                                s[1], Integer.parseInt(s[2])))
                 .toList();
    }
}
