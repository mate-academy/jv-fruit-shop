package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {

    private static final String COMA = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> getTransactionData(List<String> data) {
        if (data != null) {
            data.remove(0);
            return data.stream()
                    .map(s -> s.split(COMA))
                    .map(p -> new FruitTransaction(FruitTransaction.getOperationCode(p[OPERATION]),
                            p[FRUIT], Integer.parseInt(p[QUANTITY])))
                    .collect(Collectors.toList());
        }
        throw new NullPointerException("Data can't be null.");
    }
}
