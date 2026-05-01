package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();

        if (lines == null) {
            return result;
        }

        for (String line : lines) {
            if (line == null || line.isBlank()) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                continue;
            }

            try {
                FruitTransaction transaction = new FruitTransaction(
                        FruitTransaction.Operation.fromCode(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2]));
                result.add(transaction);
            } catch (RuntimeException e) {
                throw new RuntimeException("The mistake is " + e);
            }
        }

        return result;
    }
}
