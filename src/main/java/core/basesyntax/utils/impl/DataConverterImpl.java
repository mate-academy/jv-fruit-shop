package core.basesyntax.utils.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationDefStrategy;
import core.basesyntax.utils.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private OperationDefStrategy operationDefStrategy;

    public DataConverterImpl(OperationDefStrategy operationDefStrategy) {
        this.operationDefStrategy = operationDefStrategy;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        List<FruitTransaction> result = new ArrayList<>();
        list.remove(0);
        for (String line : list) {
            String[] parts = line.split(",");
            result.add(new FruitTransaction(
                    operationDefStrategy.get(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2])
            ));
        }
        return result;
    }
}
