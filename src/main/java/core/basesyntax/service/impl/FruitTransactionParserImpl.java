package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> toTransactions(List<String> data) {
        FruitOperationValidatorImpl fruitOperationValidator = new FruitOperationValidatorImpl();
        List<FruitTransaction> records = new ArrayList<>();
        data.stream().map(line -> line.split(SEPARATOR)).forEach(tmp -> {
            fruitOperationValidator.validate(tmp);
            records.add(new FruitTransaction(FruitTransaction.Operation
                    .get(tmp[TYPE_INDEX]), tmp[FRUIT_INDEX],
                    Integer.parseInt(tmp[AMOUNT_INDEX])));
        });
        return records;
    }
}
