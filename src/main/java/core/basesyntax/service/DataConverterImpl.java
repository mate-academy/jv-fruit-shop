package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataConverterImpl implements DataConverter {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            String[] words = line.split(COMMA);
            String type = words[TYPE];
            String fruit = words[FRUIT];
            String quantity = words[QUANTITY];
            Optional<FruitTransaction.Operation> optionalOperation = FruitTransaction.Operation
                    .getByType(type);
            optionalOperation.ifPresent(operation -> transactions.add(new FruitTransaction(
                    operation, fruit, Integer.parseInt(quantity))));
        }
        return transactions;
    }
}
