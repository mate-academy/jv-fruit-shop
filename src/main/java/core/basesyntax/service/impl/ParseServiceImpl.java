package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        if (data != null && !data.isEmpty()) {
            data.remove(HEADER_INDEX);
            return data.stream()
                    .map(this::getFromCsvRow)
                    .collect(Collectors.toList());
        }
        throw new NullPointerException("Data can't be null.");
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getByCode(fields[OPERATION_INDEX]));
        fruitTransaction.setFruitName(fields[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(new BigDecimal(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
