package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            FruitTransaction transaction = new FruitTransaction(
                    FruitTransaction.Operation.fromCode(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2]));
            result.add(transaction);
        }
        return result;
    }
}
