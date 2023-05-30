package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertService;
import java.util.ArrayList;
import java.util.List;

public class ConvertServiceImpl implements ConvertService {
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        List<FruitTransaction> pays = new ArrayList<>();
        for (String string : transactions) {
            String[] split = string.split(SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getCode(split[0]);
            String fruits = split[1];
            int size = Integer.parseInt(split[2]);
            pays.add(new FruitTransaction(operation, fruits, size));
        }
        return pays;
    }
}
